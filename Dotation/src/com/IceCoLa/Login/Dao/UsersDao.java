package com.IceCoLa.Login.Dao;

import com.IceCoLa.Login.Pojo.User;

public interface UsersDao {
    void addUser();
    void deleteUser();
    User searchUser();
    void changeUser();

}
