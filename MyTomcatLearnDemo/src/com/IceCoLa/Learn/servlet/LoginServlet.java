package com.IceCoLa.Learn.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        设置响应编码格式
        resp.setContentType("text/html;charset=utf8");
//        获取请求信息
//        处理请求
//        响应处理结果
//            获取request作用域

        req.setAttribute("str",req.getAttribute("str"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/loginPage.jsp");
        dispatcher.forward(req,resp);




    }
}
