package com.IceCoLa.controller;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import com.IceCoLa.pojo.Demo;
import com.IceCoLa.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


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
    public String demo4(String name,int age) {
        System.out.println(name + "  " + age);
        /*直接写是转发forward*/
//        return "/main.jsp";
        /*redirect：路径   此方式为重定向*/
        return "redirect:/main.jsp";
    }

}
