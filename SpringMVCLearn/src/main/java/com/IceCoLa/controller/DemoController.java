package com.IceCoLa.controller;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import com.IceCoLa.pojo.Demo;
import com.IceCoLa.pojo.People;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.Map;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public String demo(People people, @RequestParam(value = "name", defaultValue = "ming", required = true) String name, @RequestParam(value = "age", defaultValue = "10") int age, @RequestParam("hover") List<String> hover) {
        System.out.println(people + "  " + name + "  " + age + "  " + hover);
        return "/main.jsp";
    }

    @RequestMapping("/demo2")
    public String demo2(Demo demo) {
        System.out.println(demo);
        return "/main.jsp";
    }

    @RequestMapping("demo3/{name}/{age}")
    public String demo3(@PathVariable String name, @PathVariable int age) {
        System.out.println(name + "  " + age);
        return "/main.jsp";
    }

    @RequestMapping("demo4")
    public String demo4(String name, int age) {
        System.out.println(name + "  " + age);
        /*直接写是转发forward*/
//        return "/main.jsp";
        /*redirect：路径   此方式为重定向*/
        return "redirect:/main.jsp";
    }

    /*设置了@ResponseBody的控制器，恒不跳转，直接将返回值类型以json形式返回*/
    @ResponseBody
    @GetMapping("/demo5")
    public String demo5() {
        People p = new People();
        p.setAge(1);
        p.setName("李林");
        return "main.jsp";
    }

    @GetMapping("demo6")
    public String demo6(HttpServletRequest httpServletRequest, HttpSession sessionParam) {
        httpServletRequest.setAttribute("req", "req的值");
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("session", "session的值");
        sessionParam.setAttribute("sessionParam", "sessionParam");
        ServletContext application = httpServletRequest.getServletContext();
        application.setAttribute("application", "application");
        return "/main.jsp";
    }

    @GetMapping("demo7")
    /*使用@SessionAttribute取得session作用域的值*/
    public String demo7(@SessionAttribute String session, HttpServletRequest httpServletRequest) {
        HttpSession session1 = httpServletRequest.getSession();
        session1.setAttribute("session", session + "123456");
        return "/main.jsp";
    }

    @GetMapping("demo8")
    /*map中的值是被放到request作用域中了*/
    public String demo8(Map<String, Object> map) {
        map.put("key", "map的值");
        return "/main.jsp";
    }

    @GetMapping("demo9")
    /*map中的值是被放到request作用域中了*/
    public String demo9(Model model) {
        model.addAttribute("model", "model的值");
        return "/main.jsp";
    }

    @RequestMapping("demo10")
    public ModelAndView demo10() {
        ModelAndView modelAndView = new ModelAndView("/main.jsp");
        modelAndView.addObject("mav", "mav的值");
        return modelAndView;
    }

    @RequestMapping("download")
    /*访问资源时响应头如果没有设置content-disposition,浏览器默认按照inline值进行处理*/
    /*只需要修改响应头中的content-disposition的值为*/
    public void demo11(HttpServletResponse response, HttpServletRequest request) throws IOException {
        /*设置响应流中文件进行下载*/
        System.out.println(1);
        response.setHeader("Content-Disposition", "attachment;filename=abc.txt");
        /*把二进制流放入响应体中*/
        System.out.println(2);
        ServletOutputStream outPutStream = response.getOutputStream();
        System.out.println(3);
        String path = request.getServletContext().getRealPath("/files");
        System.out.println(path);
        File file = new File(path, "abc.txt");
        System.out.println(file);
        InputStream inputStream = new FileInputStream(file);
        int x = -1;
        while ((x = inputStream.read()) != -1) {
            outPutStream.write(x);
        }
        outPutStream.flush();
        outPutStream.close();
    }
}
