package com.IceCoLa.dao.impl;

import com.IceCoLa.dao.LoginDao;
import com.IceCoLa.pojo.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String userName, String password) throws SQLException {

        //        声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //声明数据存储对象
        User u = null;

        try {
            //        加载jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");
            //        获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "526995");
            //     创建Sql命令
            String insertSql = "insert into t_user values(default," + "\'" + userName + "\'," + password + "\',)";
            String selectSql = "select * from t_user where uname=? and pwd=?";
            //     创建Sql命令对象
            ps = conn.prepareStatement(selectSql);
            //给占位符赋值
            ps.setObject(1, userName);
            ps.setObject(2, password);
            //            执行
            rs = ps.executeQuery();
            //            遍历执行结果
            while (rs.next()) {
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
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
        return u;
    }
}
