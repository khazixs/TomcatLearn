package com.IceCoLa.service.serviceImpl;/*
 * @program: MybatisLearn
 * @author: IceCoLa
 */

import com.IceCoLa.dao.IUserDao;
import com.IceCoLa.domain.PageInfo;
import com.IceCoLa.domain.User;
import com.IceCoLa.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    @Override
    public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNumber(pageNumber);
        pageInfo.setPageSize(pageSize);
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("pageStart", pageSize * (pageNumber - 1));
        map.put("pageSize", pageSize);
        int total = userDao.findTotal();
        List<User> users = userDao.findByPage(map);
        sqlSession.commit();
        pageInfo.setList(users);
        pageInfo.setTotal(total);
        sqlSession.close();
        return pageInfo;
    }
}
