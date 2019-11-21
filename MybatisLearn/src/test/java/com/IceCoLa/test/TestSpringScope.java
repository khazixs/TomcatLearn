package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.domain.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringScope {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        People p1 = ac.getBean("people", People.class);
        People p2 = ac.getBean("people", People.class);
        //当People的bean标签里边的scope属性是Singleton时，输出为true；是prototype时输出为false；
        System.out.println(p1 == p2);
    }
}
