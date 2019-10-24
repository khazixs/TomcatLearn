package com.IceCoLa.Learn.service;

import com.IceCoLa.Learn.pojo.User1;

import java.sql.SQLException;

public interface UserService {
    User1 getUserInfoService(String name) throws SQLException;
}
