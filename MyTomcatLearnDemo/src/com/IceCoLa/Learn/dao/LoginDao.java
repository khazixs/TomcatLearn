package com.IceCoLa.Learn.dao;

import com.IceCoLa.Learn.pojo.User;

import java.sql.SQLException;

//数据访问层，数据库层接口
public interface LoginDao {
    User checkLoginDao(String userName,String password) throws SQLException;
    User checkUidDao(String uid) throws SQLException;
}
