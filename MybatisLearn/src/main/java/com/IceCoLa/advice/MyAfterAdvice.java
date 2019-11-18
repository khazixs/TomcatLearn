package com.IceCoLa.advice;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        /*Object o ——》切点方法返回值
        /*Method method ——》切点方法
        /*Object[] objects ——》切点方法参数
        /*Object o1 ——》切点方法所在的对象
         * */
//        System.out.println(o);
//        System.out.println(method);
//        System.out.println(Arrays.toString(objects));
//        System.out.println(o1);
        System.out.println("后置通知");
    }
}
