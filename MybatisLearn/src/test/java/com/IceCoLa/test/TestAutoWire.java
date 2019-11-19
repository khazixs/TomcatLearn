package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.domain.Purchaser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWire {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Purchaser purchaser = ac.getBean("purchaser",Purchaser.class);
        System.out.println(purchaser.toString());
    }
}
