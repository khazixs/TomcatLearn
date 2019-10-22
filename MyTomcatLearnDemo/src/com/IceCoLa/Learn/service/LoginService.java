package com.IceCoLa.Learn.service;

import com.IceCoLa.Learn.pojo.User;

import java.sql.SQLException;

public interface LoginService {
    //校验用户登录信息
    //校验用户登录信息
    User checkLoginService(String userName, String password) throws SQLException;
    //校验用户Cookie信息
    User checkUidService(String uid) throws SQLException;
}
