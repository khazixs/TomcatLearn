package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import org.springframework.beans.factory.annotation.Value;

public class Test01 {
    @Value("${jdbc.username}")
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
