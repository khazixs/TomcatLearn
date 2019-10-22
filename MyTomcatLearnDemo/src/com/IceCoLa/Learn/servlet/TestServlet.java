package com.IceCoLa.Learn.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession hs = req.getSession();
//        System.out.println(hs.getAttribute("key"));
//        System.out.println(hs.getId());
        ServletContext sc = this.getServletContext();
        System.out.println(sc.getAttribute("str"));
    }
}
