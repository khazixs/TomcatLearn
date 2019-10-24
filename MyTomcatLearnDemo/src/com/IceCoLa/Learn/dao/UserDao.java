package com.IceCoLa.Learn.dao;

import com.IceCoLa.Learn.pojo.User1;

import java.sql.SQLException;

public interface UserDao {
    User1 getUserInfo(String name) throws SQLException;
}
