package com.IceCoLa.Learn.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax1")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf8");

        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        System.out.println(name + ":" + password);
//        try {
//            Thread.sleep(2000);
//            resp.getWriter().write("欢乐时光现在开始啦！");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
