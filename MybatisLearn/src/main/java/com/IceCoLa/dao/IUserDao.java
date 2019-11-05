package com.IceCoLa.dao;

import com.IceCoLa.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
* 用户持久层接口*/
public interface IUserDao {
//    查询所有对象
    @Select("select * from user")
    List<User> findAll();
 }
