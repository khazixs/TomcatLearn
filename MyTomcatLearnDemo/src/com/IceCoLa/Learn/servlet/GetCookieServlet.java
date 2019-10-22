package com.IceCoLa.Learn.servlet;

import com.IceCoLa.Learn.pojo.User;
import com.IceCoLa.Learn.service.LoginService;
import com.IceCoLa.Learn.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/*Cookie信息校验
 * 判断请求中是否携带正确的Cookie信息
 * 如果有则校验Cookie信息是否正确，正确则直接响应主页界面给用户，不正确则响应登录界面给用户
 * 没有则请求转发给登陆界面*/
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cks = req.getCookies();
        if (cks != null) {
            String uid = "";
            for (Cookie c : cks) {
                if ("uid".equals(c.getName())) {
                    uid = c.getValue();
                }
            }
            if ("".equals(uid)) {
                req.getRequestDispatcher("login").forward(req, resp);
            } else {
                LoginService ls = new LoginServiceImpl();
                User u = null;
                try {
                    u = ls.checkUidService(uid);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (u != null) {
                    resp.sendRedirect("main");
                } else {
                    req.getRequestDispatcher("login").forward(req, resp);
                }
            }
        } else {
            req.getRequestDispatcher("login").forward(req, resp);
        }

    }
}
