package com.IceCoLa.service.impl;

import com.IceCoLa.dao.LoginDao;
import com.IceCoLa.dao.impl.LoginDaoImpl;
import com.IceCoLa.pojo.User;
import com.IceCoLa.service.LoginService;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    //创建dao层过渡对象
    LoginDao ld = new LoginDaoImpl();

    @Override
    public User checkLoginService(String userName, String password) throws SQLException {
//        可以做二次校验，账户锁定等业务层逻辑
//        System.out.println("QAQ");
        return ld.checkLoginDao(userName,password);
    }
}
