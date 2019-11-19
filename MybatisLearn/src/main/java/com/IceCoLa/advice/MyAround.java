package com.IceCoLa.advice;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕-前置");
        Object result = methodInvocation.proceed();//放行，调用切点方法
        System.out.println("环绕-前置");
        return result;
    }
}
