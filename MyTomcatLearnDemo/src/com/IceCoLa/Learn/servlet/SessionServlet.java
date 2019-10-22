package com.IceCoLa.Learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//session 解决一个用户的不同请求处理的数据共享问题
//原理：用户第一次访问服务器，服务器会创建一个session对象给次用户，并将该session对象的Jsessionid使用cookie技术存储到浏览器中，保证用户的其他请求能够获取同一个session对象，也保证了不同的请求能够获取共享数据
//特点：服务器端的存储技术，存储在服务器，有服务器进行创建，依赖cookie技术，有效期是一次会话
//使用：创建session对象/获取session对象都是一句话
//HttpSession hs = req.getSession();
//如果请求中拥有session标识Jsessionid，则返回其对应的session队形
//如果请求中没有session标识，则创建新的session对象，并将其Jsessionid作为从cookie数据存储到浏览器中
//如果session失效了，也会重新创建一个session对象，并激情JSESSIONID存储在浏览器中
//设置session有效时间：hs.setMaxInactiveInterval(5);//单位是秒
//注意：在指定的时间内session没有被使用则销毁，如果使用了则重新计时
//JSESSIONID存储在Cookie的临时存储空间中，浏览器关闭即失效
//设置session强制失效 hs.invalidate();

//使用时机：一般用户在登陆web项目时，会将用户的个人信息存储到Session中，供该用户的其他请求使用
//总结：session解决了一个用户的不同数据共享问题，只要jsessionid不失效和session不失效的情况下，用户的任意请求都能获取到同一个session对象
//作用域：一次会话，在JSESSIONID和SESSION对象不失效的情况为整个项目内
//session时效处理：将用户请求中的JSESSIONID和后台获取的SESSION对象的JSESSIONID进行比对，如果一直则session没有失效，如果不一致则证明session失效了。重定向到登录界面，让用户重新登录
public class SessionServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession hs = req.getSession();
        hs.setAttribute("key","asd");
        hs.setMaxInactiveInterval(5);//单位是秒
        hs.invalidate();//设置session强制失效
    }
}
