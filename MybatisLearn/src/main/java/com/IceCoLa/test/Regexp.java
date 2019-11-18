package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import java.util.regex.Pattern;

public class Regexp {
    public static void main(String[] args) {
        String regexp = "L*";
        String str = "LuLu";
        System.out.println(str.matches(regexp));
        System.out.println(Pattern.matches(regexp,str));
    }
}
