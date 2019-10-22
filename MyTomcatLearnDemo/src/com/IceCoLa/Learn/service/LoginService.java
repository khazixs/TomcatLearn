package com.IceCoLa.Learn.service;

import com.IceCoLa.Learn.pojo.User;

import java.sql.SQLException;

public interface LoginService {
    User checkLoginService(String userName, String password) throws SQLException;

}
