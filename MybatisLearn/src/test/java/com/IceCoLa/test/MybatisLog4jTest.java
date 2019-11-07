package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisLog4jTest {
    public static void main(String[] args) throws IOException {
       InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        sqlSession.selectList("com.IceCoLa.dao.IUserDao.findAll");
        sqlSession.close();
    }
}
