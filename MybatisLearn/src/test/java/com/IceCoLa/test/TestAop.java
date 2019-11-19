package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
//        Demo demo = new Demo();
//        demo.demo1();
//        demo.demo2();
//        demo.demo3();
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Demo demo = ac.getBean("demo", Demo.class);
//        demo.demo1();
//        demo.demo2("HelloSpring");
//        String strRet = demo.demo3();
//        System.out.println(strRet);
//        demo.demo4();
        TestAspectJDemo testAspectJDemo = ac.getBean("testAspectJDemo",TestAspectJDemo.class);
        testAspectJDemo.Demo1();
    }
}
