package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.dao.IUserDao;
import com.IceCoLa.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpringMybatis {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext默认去class文件夹根目录开始寻找*/
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDao userDao = ac.getBean("IUserDao", IUserDao.class);
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
