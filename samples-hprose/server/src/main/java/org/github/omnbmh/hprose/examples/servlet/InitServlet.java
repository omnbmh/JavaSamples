package org.github.omnbmh.hprose.examples.servlet;

import org.github.omnbmh.hprose.examples.ServerTools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by b1rd on 2016/11/3.
 */
public class InitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        // 加载配置文件
        String protrol = this.getInitParameter("protrol");
        String host = this.getInitParameter("host");
        String port = this.getInitParameter("port");
        ServerTools.register(protrol, host, Integer.parseInt(port));
    }
}
