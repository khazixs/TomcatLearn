package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTest01 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Test01 test01 = ac.getBean("test01",Test01.class);
        System.out.println(test01.getStr());
    }
}
