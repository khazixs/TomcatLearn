package com.IceCoLa.Learn.service.impl;

import com.IceCoLa.Learn.dao.LoginDao;
import com.IceCoLa.Learn.dao.impl.LoginDaoImpl;
import com.IceCoLa.Learn.pojo.User;
import com.IceCoLa.Learn.service.LoginService;

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

    @Override
    public User checkUidService(String uid) throws SQLException {
        return ld.checkUidDao(uid);
    }
}
