package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.service.UserService;
import com.IceCoLa.service.serviceImpl.UserServiceImpl;

import java.io.IOException;

public class TestUserServiceImpl {
    public static void main(String[] args) throws IOException {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.showPage(2, 2));
    }
}
