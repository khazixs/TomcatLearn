package com.IceCoLa.Learn.service.impl;

import com.IceCoLa.Learn.dao.UserDao;
import com.IceCoLa.Learn.dao.impl.UserDaoImpl;
import com.IceCoLa.Learn.pojo.User1;
import com.IceCoLa.Learn.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();
    @Override
    public User1 getUserInfoService(String name) throws SQLException {
        User1 u1 = ud.getUserInfo(name);
        return u1;
    }
}
