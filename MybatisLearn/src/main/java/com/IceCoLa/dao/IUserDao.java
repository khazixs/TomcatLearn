package com.IceCoLa.dao;

import com.IceCoLa.domain.User;

import java.util.List;

/*
* 用户持久层接口*/
public interface IUserDao {
//    查询所有对象
    List<User> findAll();
 }
