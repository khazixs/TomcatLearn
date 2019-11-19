package com.IceCoLa.advice;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import org.aopalliance.aop.Advice;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice implements Advice {
    public void myBefore() {
        System.out.println("前置通知");
    }

    public void myAfter() {
        /*无论是否出错这个后置通知都会执行*/
        System.out.println("后置通知after");
    }

    public void myAfterReturning() {
        /*如果程序出错则这个后置通知不执行*/
        System.out.println("后置通知returning");
    }

    public void myThrow() {
        System.out.println("异常通知");
    }

    public Object myAround(ProceedingJoinPoint p) throws Throwable {
        System.out.println("环绕通知-前置");
        Object result = p.proceed();
        System.out.println("环绕通知-后置");
        return result;
    }


}
