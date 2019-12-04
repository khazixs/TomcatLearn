package com.IceCoLa.controller;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ResponseBody
@RequestMapping("/testLogin")
@Controller
public class TestController {
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        httpSession.getAttribute("User");
        String sessionId = httpSession.getId();
        System.out.println("SessionId是：" + sessionId);
        httpSession.setAttribute("name","Ming");
        httpSession.setAttribute("User",new Object());
        return "";
    }

}
