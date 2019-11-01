package com.IceCoLa.dao.impl;

import com.IceCoLa.dao.UsersDao;
import com.IceCoLa.pojo.User;

import java.sql.*;

public class UsersDaoImpl implements UsersDao {
    @Override
    public void addUser() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public User searchUser(String userName,String password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dotation", "root", "526995");
            String selectSql = "select * from users where userName=?&&password=?";
            preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1,userName);
            preparedStatement.setObject(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setCoin(resultSet.getDouble("coin"));
                user.setPerformance(resultSet.getString("performance"));
                user.setUserEmail(resultSet.getString("userEmail"));
                user.setUserAvatar(resultSet.getBytes("userAvatar"));
                user.setUserSex(resultSet.getString("userSex"));
                user.setUserLevel(resultSet.getString("userLevel"));
                user.setUserQRCode(resultSet.getBytes("userQRCode"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
            preparedStatement.close();
            resultSet.close();
        }

        return user;
    }

    @Override
    public void changeUser() {

    }
}
