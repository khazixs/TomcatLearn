package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class TestJackson {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.setUsername("张三");
        user.setId(2);
        user.setSex("男");
        user.setAddress("我的家");
        user.setBirthday(new Date());
        /*即能够通过jackson将对象转换成JSON形式*/
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(user);
        System.out.println(result);

    }


}
