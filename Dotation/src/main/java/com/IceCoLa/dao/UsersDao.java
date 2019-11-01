package com.IceCoLa.dao;

import com.IceCoLa.pojo.User;

import java.sql.SQLException;

public interface UsersDao {
    void addUser();
    void deleteUser();
    User searchUser(String userName,String password) throws SQLException;
    void changeUser();

}
