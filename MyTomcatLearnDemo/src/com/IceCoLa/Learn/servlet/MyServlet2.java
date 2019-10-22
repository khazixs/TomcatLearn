package com.IceCoLa.Learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("this is my second servlet");
        System.out.println("MyServlet2.service()");
        //响应处理结果
            //设置响应头
        resp.setHeader("aaa","two flowers");
        resp.setHeader("aaa","two cars");
        resp.addHeader("key","iphone");
        resp.addHeader("key","android");
//        设置响应编码格式
//        resp.setHeader("ContentType","text/html;charset=utf8");//两个方法等效
        resp.setContentType("text/html;charset=utf8");
//        设置响应状态码
//        resp.sendError(404,"error");
//        设置相应实体
        resp.getWriter().write("<b> BOOM BOOM BOOM BOOM BOOM BOOM BOOM</b> BOOM BOOM BOOM BOOM BOOM BOOM BOOM </b>BOOM BOOM BOOM BOOM BOOM BOOM BOOM</b>  BOOM BOOM BOOM BOOM BOOM BOOM BOOM BOOM BOOM ");
    }
}
