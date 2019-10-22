package com.IceCoLa.servlet;

import com.IceCoLa.pojo.User;
import com.IceCoLa.service.LoginService;
import com.IceCoLa.service.impl.LoginServiceImpl;
import com.mysql.jdbc.log.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

/*
 *request对象学习：
 * 作用：request 对象中封存了当前请求的所有请求信息
 * 使用：获取请求头数据，获取请求行数据，获取用户数据
 * 注意：request对象有tomcat服务器创建，并作为实参传递给处理请求的servlet的service方法
 */
public class LoginServiceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //  =================================设置请求编码格式========================================================================
        req.setCharacterEncoding("utf-8");
        //  =================================设置响应编码格式========================================================================
        resp.setContentType("text/html;charset=utf8");
//        获取请求信息
        String userName = req.getParameter("userName");
//        userName = new String(userName.getBytes("iso8859-1"),"utf-8");
        String password = req.getParameter("pwd");
        System.out.println(userName + ":" + password);
        String[] favs = req.getParameterValues("fav");

//  =================================处理请求信息========================================================================
//        获取业务层对象
        LoginService ls = new LoginServiceImpl();
        User u = new User();
        try {
            u = ls.checkLoginService(userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(u);

//  =================================响应处理结果========================================================================
        if(u!=null){
//            req.getRequestDispatcher("main").forward(req,resp);//使用重定向
            resp.sendRedirect("main");
        }else{
            req.setAttribute("str","用户名或密码错误");
            req.getRequestDispatcher("login").forward(req,resp);
        }

//        System.out.println("this is my first servlet.");
//        获取请求数据
//                获取请求方式
//        System.out.println("请求方式：" + req.getMethod());
//        获取请求URL
//        System.out.println("URL：" + req.getRequestURI());
//        获取协议
//        System.out.println("协议：" + req.getProtocol());
//        System.out.println("协议：" + req.getScheme());
//        获取请求行数据
//        System.out.println(req.getHeader("User-Agent"));
//        获取所有的请求行的键的枚举
//        Enumeration e = req.getHeaderNames();
//        while (e.hasMoreElements()) {
//            System.out.println(e.nextElement() + ":" + req.getHeader((String) e.nextElement()));
//        }
//        获取用户数据
//        String name = req.getParameter("userName");
//        String pwd = req.getParameter("pwd");
//        System.out.println(name + ":" + pwd);
//        String fav = req.getParameter("fav");//getParameter不能获取同键多值，会漏值
//        String[] favs = req.getParameterValues("fav");//获取同键名的所有键值
//        if (favs != null) {
//            for (String value : favs) {
//                System.out.println(value);
//            }
//        }
//        获取所有的用户数据键名枚举 ———— req.getParameterNames();

    }
}
