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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3.使用工厂对象创建session对象
        sqlSession = factory.openSession();//可以传递参数true，表示自动提交事务，默认SqlS
        // ession是不自动提交事务的
        // 4.使用session对象生成代理
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    /*查找全部用户*/
    @Test
    public void testFindAll() {
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /*保存用户*/
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("save");
        user.setBirthday(new Date());
        user.setAddress("London");
        user.setSex("男");
        System.out.println("之前" + user.getId());
        //5.使用代理对象执行方法
        userDao.saveUser(user);
        System.out.println("之后" + user.getId());
    }

    /*更新用户*/
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(5);
        user.setUsername("lan");
        user.setBirthday(new Date());
        user.setAddress("Japan");
        user.setSex("男");
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(15);
    }

    @Test
    public void testFindById() {
        System.out.println(userDao.findById(1));
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%小%");
//        List<User> users = userDao.findByName("小");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        System.out.println(userDao.findTotal());
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        inputStream.close();
    }
}
