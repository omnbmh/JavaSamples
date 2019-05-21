package com.gitee.cobra.spring.servlet;

import com.gitee.cobra.spring.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CobraDispacthServlet extends HttpServlet {

    private Properties properties = new Properties();
    private List<String> classNames = new ArrayList<>();
    private Map<String, Object> ioc = new HashMap<>();
    private List<Handler> handlerMapping = new ArrayList<>();
    private Map<String, Method> handlerMappingMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {


        Handler handler = getHandler(req);
        if (null == handler) {
            resp.getWriter().write("404 Not Found");
            return;
        }
        Class[] paramTypes = handler.method.getParameterTypes();
        Object[] paramValues = new Object[paramTypes.length];

        Map<String, String[]> params = req.getParameterMap();
        for (Map.Entry<String, String[]> param : params.entrySet()) {
            String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "");
            // 如果 找到匹配的对象 则开始填充参数值
            if (!handler.paramIndexMapping.containsKey(param.getKey())) {
                continue;
            }
            int index = handler.paramIndexMapping.get(param.getKey());
            paramValues[index] = convert(paramTypes[index], value);

        }
        // 找到了


        // 设置
        int reqIndex = handler.paramIndexMapping.get(HttpServletRequest.class.getName());
        paramValues[reqIndex] = req;
        int respIndex = handler.paramIndexMapping.get(HttpServletResponse.class.getName());
        paramValues[respIndex] = resp;
        handler.method.invoke(handler.controller, paramValues);

    }

    private Handler getHandler(HttpServletRequest req) {
        if (handlerMapping.isEmpty()) {
            return null;
        }
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");
        for (Handler handler : handlerMapping) {
            try {
                Matcher matcher = handler.pattern.matcher(url);
                if (!matcher.matches()) {
                    continue;
                }
                return handler;
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }


    private Object convert(Class type, String value) {
        if (Integer.class == type) {
            return Integer.valueOf(value);
        }
        return value;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
//        super.init(config);

        // 加载配置
        doLoadingConfig(config.getInitParameter("contextConfigLocation"));
        // 扫描
        doScan(properties.getProperty("scanPackage"));
        // 实例化
        doInstance();
        // 自动注入 依赖注入
        doAutowired();
        // 初始化
        doInitHandleMapping();

        System.out.printf("Cobra Spring is inited");
    }

    private void doInitHandleMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class clazz = entry.getValue().getClass();

            if (!clazz.isAnnotationPresent(CobraController.class)) {
                continue;
            }

            // 获取 url 前缀
            String baseUrl = "";
            if (clazz.isAnnotationPresent(CobraRequestMapping.class)) {
                CobraRequestMapping requestMapping = (CobraRequestMapping) clazz.getAnnotation(CobraRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            // Spring 只认 public 方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(CobraRequestMapping.class)) {
                    continue;
                }
                CobraRequestMapping requestMapping = (CobraRequestMapping) method.getAnnotation(CobraRequestMapping.class);
                String url = (baseUrl + requestMapping.value()).replaceAll("/+", "/");
                System.out.printf("Mapped " + url + " into " + method);


                handlerMappingMap.put(url, method);


                Handler handler = new Handler(Pattern.compile(url), entry.getValue(), method);
                handlerMapping.add(handler);
            }
        }
    }

    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(CobraAutowired.class)) {
                    CobraAutowired autowired = field.getAnnotation(CobraAutowired.class);
                    String beanName = autowired.value().trim();
                    if ("".equals(beanName)) {
                        beanName = field.getType().getName();
                    }
                    try {
                        // 针对 private 透明
                        field.setAccessible(true);
                        // 参数 类 属性值
                        field.set(entry.getValue(), ioc.get(beanName));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private void doInstance() {
        // 是否扫描到类
        if (classNames.isEmpty()) {
            return;
        }

        for (int i = 0; i < classNames.size(); i++) {
            try {
                Class clazz = Class.forName(classNames.get(i));
                if (clazz.isAnnotationPresent(CobraController.class)) {
                    Object obj = clazz.newInstance();
                    String key = clazz.getSimpleName();
                    ioc.put(key, obj);
                }
                if (clazz.isAnnotationPresent(CobraService.class)) {
                    CobraService service = (CobraService) clazz.getAnnotation(CobraService.class);
                    String beanName = service.value();
                    if ("".equals(beanName.trim())) {
                        beanName = clazz.getSimpleName();
                    }
                    Object obj = clazz.newInstance();
                    ioc.put(beanName, obj);

                    Class[] interfaces = clazz.getInterfaces();
                    for (Class j : interfaces) {
                        ioc.put(j.getName(), obj);
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void doScan(String scanPackage) {
        URL url = this.getClass().getResource("/" + scanPackage.replaceAll("\\.", "/"));
//        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScan(scanPackage + "." + file.getName());
            } else {
                String className = (scanPackage + "." + file.getName()).replace(".class", "");
                classNames.add(className);
            }
        }
    }

    private void doLoadingConfig(String configPath) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(configPath);
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 内部类
     */
    private class Handler {
        protected Object controller;
        protected Method method;
        protected Pattern pattern;
        protected Map<String, Integer> paramIndexMapping;

        protected Handler(Pattern pattern, Object controller, Method method) {
            this.pattern = pattern;
            this.controller = controller;
            this.method = method;
            paramIndexMapping = new HashMap<>();
            putParamIndexMapping(method);
        }

        private void putParamIndexMapping(Method method) {
            Annotation[][] pa = method.getParameterAnnotations();
            for (int i = 0; i < pa.length; i++) {
                for (Annotation a : pa[i]) {
                    if (a instanceof CobraRequestParam) {
                        String paramName = ((CobraRequestParam) a).value();
                        if (!"".equals(paramName)) {
                            paramIndexMapping.put(paramName, i);
                        }
                    }
                }
            }

            // 提取方法中的request和response参数
            Class[] paramsTypes = method.getParameterTypes();
            for (int i = 0; i < paramsTypes.length; i++) {
                Class type = paramsTypes[i];
                if (type == HttpServletRequest.class ||
                        type == HttpServletResponse.class) {
                    paramIndexMapping.put(type.getName(), i);
                }
            }
        }
    }
}
