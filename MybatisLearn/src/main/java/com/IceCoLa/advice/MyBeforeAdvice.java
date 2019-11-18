package com.IceCoLa.advice;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        /*Method method 表示 切点方法对象
         * Object[] objects 表示 切点方法参数
         * Object o 表示 切点方法所在的对象*/
//        System.out.println("切点方法对象：" + method + "方法名：" + method.getName());
//        if (objects != null && objects.length > 0) {
//            System.out.println("切点方法参数：" + objects);
//        }
//        System.out.println(o);
        System.out.println("执行前置通知");
    }
}
