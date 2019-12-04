package com.IceCoLa.test;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import org.apache.commons.io.FileUtils;
import sun.plugin.com.Utils;

import java.io.File;
import java.io.IOException;

public class test03 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\TomcatLearn\\SpringMVCLearn\\out\\artifacts\\SpringMVCLearn_war_exploded\\files\\abc.txt");
        byte[] bytes = FileUtils.readFileToByteArray(file);
        System.out.println(new String(bytes));
    }
}
