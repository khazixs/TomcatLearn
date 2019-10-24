package com.IceCoLa.Learn.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/*servletContext对象
 * 解决不同的对象使用相同的数据
 * 特点：服务器创建
 *       用户共享
 * 生命周期：服务器启动到服务器关闭
 * 使用：获取ServletContext对象
 *       使用ServletContext对象完成数据共享
 * 三种方式：
 *      //第一种方式
        ServletContext sc = this.getServletContext();
        //第二种方式
        ServletContext sc2 = this.getServletConfig().getServletContext();
        //第三种方式
        ServletContext sc3 = req.getSession().getServletContext();
   数据存储：sc.setAttribute("str","ServletContext数据共享");
   数据获取：sc.getAttribute("str");
   * 注意不同的用户可以给ServletContext对象进行数据存取。
   * 获取的数据不存在返回null
   * 获取项目中web.xml文件中的全局配置数据:String str = sc.getInitParameter("name");或者Enumeration<String> enums = sc.getInitParameterNames();
   * 后者可以一次性获取所有的键名的枚举
   * web.xml配置如下：
   *<context-param>
        <param-name>name</param-name>
        <param-value>wuhan</param-value>
    </context-param>
   *作用：将静态数据和代码解耦
   *
   * 获取项目web下的资源的绝对路径:String path = sc.getRealPath("/Images/1.jpg");
   * 获取项目web下的资源的刘对象：InputStream is = sc.getResourceAsStream("/Images/1.jpg");
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
        String str = sc.getInitParameter("name");
        System.out.println(str);
        Enumeration<String> enums = sc.getInitParameterNames();
        System.out.println(enums);
        String path = sc.getRealPath("/Images/1.jpg");
        System.out.println(path);
        InputStream is = sc.getResourceAsStream("/Images/1.jpg");

    }
}
