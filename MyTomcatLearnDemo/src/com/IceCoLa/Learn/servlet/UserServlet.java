package com.IceCoLa.Learn.servlet;

import com.IceCoLa.Learn.pojo.User1;
import com.IceCoLa.Learn.service.UserService;
import com.IceCoLa.Learn.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ajax2")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(1213441);
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf8");

        String name = req.getParameter("name");
        System.out.println("请求信息" + name);
        //获取业务层对象
        UserService us = new UserServiceImpl();
        //处理业务
        User1 u1 = new User1();
        try {
            u1 = us.getUserInfoService(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("id:" + u1.getId() + "name:" + u1.getName() + "price:" + u1.getPrice() + "location:" + u1.getLocation() + "description:" + u1.getDescription());
        if(u1!=null){
//            resp.addHeader("id",u1.getId()+"");
//            resp.addHeader("name",u1.getName()+"");
//            resp.addHeader("price",u1.getPrice()+"");
//            resp.addHeader("location",u1.getLocation()+"");
//            resp.addHeader("description",u1.getDescription()+"");
            Gson gson = new Gson();//引入Gson包可以将对象直接转换陈json形式，传给ajax对象，不用手动拼接
            System.out.println(gson.toJson(u1));
            resp.getWriter().write(gson.toJson(u1));
        }else{
            resp.getWriter().write("商店中无此英雄！");
        }
    }
}
