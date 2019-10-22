package com.IceCoLa.dao;

import com.IceCoLa.pojo.User;

import java.sql.SQLException;

//数据访问层，数据库层接口
public interface LoginDao {
    User checkLoginDao(String userName,String password) throws SQLException;
}
