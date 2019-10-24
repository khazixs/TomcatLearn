package com.IceCoLa.Learn.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*ServletConfig对象是为每一个servlet对象配置的辅助对象，可以获得servlet在web.xml中的局部配置信息*/

public class ServletConfigServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig sc = this.getServletConfig();
        String str =  sc.getInitParameter("config");
        System.out.println(str);
    }
}
