package com.IceCoLa.Learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*Cookie 解决了发送的不同请求的数据共享问题
* 使用：创建Cookie对象
*       响应Cookie信息给客户端
* 注意：一个Cookie对象存储一条数据。多条数据，可以创建多个Cookie对象进行存储
* 特点：浏览器端的存储技术
*       存储的数据声明在服务器端。
* 存储：未设置有效期的Cookie存储在浏览器运行内存中，浏览器关闭即失效
*       设置了有效期的Cookie存储在客户端的硬盘上，在有效期内符合路径要求的请求都会附带该信息
* 默认Cookie信息存储之后，每次请求都会附带，除非设置有效路径
* */
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //使用Cookie进行浏览器端的数据存储
        Cookie c = new Cookie("mouse","thinkPad");
        Cookie c2= new Cookie("key","IceCoLa");
        //设置c2的有效时间
        c2.setMaxAge(3*24*3600);
        //c2设置有效路径，路径必须带上项目名称
        c.setPath("/MyTomcatLearnDemo_war_exploded/abc");
        //响应Cookie对象
        resp.addCookie(c);
        resp.addCookie(c2);



        resp.getWriter().write("CookieLearn");
    }
}
