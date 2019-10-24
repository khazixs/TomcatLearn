package com.IceCoLa.Learn.dao.impl;

import com.IceCoLa.Learn.dao.UserDao;
import com.IceCoLa.Learn.pojo.User1;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User1 getUserInfo(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //声明数据存储对象
        User1 u1 = null;
        try {
            //        加载jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");
            //        获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "526995");
            //     创建Sql命令
            String selectSql = "select * from myheros where name=?";
            //     创建Sql命令对象
            ps = conn.prepareStatement(selectSql);
            //给占位符赋值
            ps.setObject(1,name);
            //            执行
            rs = ps.executeQuery();
            //            遍历执行结果
            while (rs.next()) {
                u1 = new User1();
                u1.setId(rs.getInt("id"));
                u1.setName(rs.getString("name"));
                u1.setPrice(rs.getDouble("price"));
                u1.setLocation(rs.getString("location"));
                u1.setDescription(rs.getString("description"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //            关闭资源
            conn.close();
            ps.close();
            rs.close();
        }
        //            返回
        return u1;
    }
}
