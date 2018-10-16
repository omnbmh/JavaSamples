package org.github.omnbmh.commons.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Http 客户端!
 */
public class CommonHttpClient {

    private static Log logger = LogFactory.getLog(CommonHttpClient.class);
    private static final CloseableHttpClient httpClient;
    private static PoolingHttpClientConnectionManager cm;
    public static final String CHARSET = "UTF-8";

    static {
        cm = new PoolingHttpClientConnectionManager();
        // 将最大连接数增加到200
        cm.setMaxTotal(200);
        // 将每个路由基础的连接增加到20
        cm.setDefaultMaxPerRoute(20);
        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000)
                .build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).setConnectionManager(cm)
                .build();
    }

    public static String getRequest(String url) {
        return getRequest(url, CHARSET);
    }

    public static String getRequest(String url, String charset) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)   //设置连接超时时间
                .setConnectionRequestTimeout(5000) // 设置请求超时时间
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)//默认允许自动重定向
                .build();

        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
//        httpGet.addHeader("Content-Type","charset=utf-8");
        String srtResult = "";
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                srtResult = EntityUtils.toString(httpResponse.getEntity(), charset);//获得返回的结果
                logger.debug(srtResult);
            } else if (httpResponse.getStatusLine().getStatusCode() == 400) {
                logger.warn("http 400");
            } else if (httpResponse.getStatusLine().getStatusCode() == 500) {
                logger.warn("http 500");
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
//            try {
            if (null != httpResponse) {
//                    httpResponse.
            }
//                httpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return srtResult;
    }

    public static String postRequest(String url, Map<String, Object> paramMap) {
        // if (StringUtils.isBlank(url)) {
        // return null;
        // }
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            List<NameValuePair> pairs = null;
            if (paramMap != null && !paramMap.isEmpty()) {
                pairs = new ArrayList<NameValuePair>(paramMap.size());
                Set<String> bkeys = paramMap.keySet();
                for (Iterator<String> itr = bkeys.iterator(); itr.hasNext(); ) {
                    String key = (String) itr.next();
                    Object value = (Object) paramMap.get(key);
                    pairs.add(new BasicNameValuePair(key, value != null ? (String) value : ""));
                }
            }
            HttpPost httpPost = new HttpPost(
                    url + "?random=" + System.currentTimeMillis() + UUID.randomUUID().toString()
                            .replace("-", ""));
            // cm.setMaxPerRoute(new HttpRoute(new HttpHost(httpPost)), 50);
            if (pairs != null && pairs.size() > 0) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
            }
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
                return null;
                // throw new RuntimeException("CommonHttpClient,error status code :" +
                // statusCode);
            }
            entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
            }
            return result;
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        } finally {// 释放资源
            try {
                if (response != null) {
                    response.close();
                }
                if (entity != null) {
                    EntityUtils.consume(entity);
                }
                // httpClient.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        return null;

    }

    public static String post(String url, List<NameValuePair> postParams) {
        return null;
    }

    public static String get(String url) {
        return null;
    }


    public static String postRequest(String url, String body) {
        logger.info("request url:" + url);
        logger.info("request body:" + body);

        if (url == null) {
            return null;
        }
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            if (null != body) {
                httpPost.setEntity(new StringEntity(body, CHARSET));
            }
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            logger.info("http request status_code - " + statusCode);
            if (statusCode != 200) {
                httpPost.abort();
                return null;
                // throw new RuntimeException("CommonHttpClient,error status code :" + statusCode);
            }
            entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
                logger.info("http post response str:" + result);
            }
            return result;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {//释放资源
            try {
                if (response != null) {
                    response.close();
                }
                if (entity != null) {
                    EntityUtils.consume(entity);
                }
                //httpClient.close();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }
}
