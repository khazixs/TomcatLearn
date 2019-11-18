package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

public class Demo {
    public void demo1() {
        System.out.println(1/0);
        System.out.println("demo1");
    }

    public void demo2(String str) {
        System.out.println("demo2" + str);
    }

    public String demo3() {
        System.out.println("demo3");
        return "demo3返回值";
    }
}
