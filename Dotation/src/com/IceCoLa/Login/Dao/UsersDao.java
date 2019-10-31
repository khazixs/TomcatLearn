package com.IceCoLa.Login.Dao;

import com.IceCoLa.Login.Pojo.User;

import java.sql.SQLException;

public interface UsersDao {
    void addUser();
    void deleteUser();
    User searchUser(String userName,String password) throws SQLException;
    void changeUser();

}
