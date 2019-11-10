package com.IceCoLa.test;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.dao.IUserDao;
import com.IceCoLa.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
        user.setId(9);
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
        System.out.println(userDao.findById(2));
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("test");
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

    @Test
    public void testFindByList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(8);
        list.add(13);
        list.add(17);
        List<User> users = userDao.findByList(list);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testInsUsers() {
        List<User> list = new ArrayList<User>();
        User u = null;
        StringBuilder stringBuilder;
        String strTemp = "";
        for (int i = 0; i < 5; i++) {
             stringBuilder = new StringBuilder();
            for (int j=0;j<5;j++){
                stringBuilder.append((char) (Math.random()*25+96));
            }
            strTemp = stringBuilder.toString();
            u = new User();
            u.setUsername(strTemp);
            list.add(u);
        }
        userDao.insUsers(list);
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        Scanner input = new Scanner(System.in);
        System.out.println("输入模糊查询字符串：");
        String str = input.nextLine();
        List<User> users = userDao.findByName(str);
        for (User u : users) {
            System.out.println(u);
        }
        sqlSession.close();
        input.close();
    }
}
