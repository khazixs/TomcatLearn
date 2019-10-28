package com.IceCoLa.Learn.filter;

/*
创建一个使用了filter接口的普通java类
覆写init()服务器启动即执行  doFilter()拦截请求的方法，在此方法中可以实现对资源的管理,执行完还要返回该方法  destroy()服务器关闭时候执行
在web.xml中配置过滤器

使用：统一编码格式设置     session管理       权限管理        资源管理（统一水印、和谐词汇等等）
*/

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class myFilter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("初始化123");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter执行了！");
//        设置编码格式
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
//        判断session
        HttpSession hs = ((HttpServletRequest)servletRequest).getSession();
        if(hs.getAttribute("user")==null){
            ((HttpServletResponse)servletResponse).sendRedirect("login");
        }
//        放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("放行回来啦！");
    }

    @Override
    public void destroy() {
        System.out.println("销毁321");
    }
}
