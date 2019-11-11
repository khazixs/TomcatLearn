package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.dao.IPurchaserDao;
import com.IceCoLa.domain.Purchaser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestTableConnection {
    private SqlSession sqlSession;
    private IPurchaserDao iPurchaserDao;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        iPurchaserDao = sqlSession.getMapper(IPurchaserDao.class);
    }

    @Test
    public void test01(){
        List<?> list = iPurchaserDao.selectAll();
        for(Object pur:list){
            System.out.println(pur);
        }
    }

    @Test
    public void selectByNameTest(){
        System.out.println(iPurchaserDao.selectByName(2));
    }
}
