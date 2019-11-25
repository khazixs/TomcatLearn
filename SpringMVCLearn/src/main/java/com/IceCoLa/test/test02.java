package com.IceCoLa.test;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import com.IceCoLa.pojo.Menu;
import com.IceCoLa.service.MenuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class test02 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuService menuServiceImpl = ac.getBean(MenuService.class);
        System.out.println(menuServiceImpl);
        List<Menu> list = menuServiceImpl.show();
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
}
