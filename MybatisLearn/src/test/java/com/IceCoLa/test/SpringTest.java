package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.domain.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
//        People people = new People();
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = ac.getBean("peo", People.class);
        System.out.println(people);
        String[] names = ac.getBeanDefinitionNames();
        for (String str : names ) {
            System.out.println(str);
        }

    }
}
