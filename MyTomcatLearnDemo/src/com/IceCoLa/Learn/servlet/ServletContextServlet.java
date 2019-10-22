package com.IceCoLa.Learn.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*servletContext对象
 * 解决不同的对象使用相同的数据
 * 特点：服务器创建
 *       用户共享
 * 生命周期：服务器启动到服务器关闭
 * 使用：获取ServletContext对象
 *       使用ServletContext对象完成数据共享
 * */
public class ServletContextServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //第一种方式
        ServletContext sc = this.getServletContext();
        //第二种方式
        ServletContext sc2 = this.getServletConfig().getServletContext();
        //第三种方式
        ServletContext sc3 = req.getSession().getServletContext();
        System.out.println(sc == sc2);
        System.out.println(sc == sc3);
        //使用ServletContext对象完成数据共享
        sc.setAttribute("str","ServletContext数据共享");
    }
}
