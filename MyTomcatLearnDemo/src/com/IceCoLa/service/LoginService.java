package com.IceCoLa.service;

import com.IceCoLa.pojo.User;

import java.sql.SQLException;

public interface LoginService {
    User checkLoginService(String userName, String password) throws SQLException;

}
