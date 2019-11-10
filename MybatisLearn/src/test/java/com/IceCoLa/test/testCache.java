package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.dao.IUserDao;
import com.IceCoLa.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testCache {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.findAll();
        sqlSession.close();
        //注意这里一定要先关闭了前一个SqlSession对象对资源的占用，其读取到的select搜出的资源才会进入缓存，否则还是会执行两次
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
        userDao1.findAll();
        sqlSession1.close();
    }
}
