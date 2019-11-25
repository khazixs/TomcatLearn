package com.IceCoLa.controller;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import com.IceCoLa.pojo.Menu;
import com.IceCoLa.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MenuController {
    @Resource/*注入实体类*/
    private MenuService menuServiceImpl;

    @GetMapping("show")
    @ResponseBody
    public List<Menu> show(){
        return menuServiceImpl.show();
    }
}
