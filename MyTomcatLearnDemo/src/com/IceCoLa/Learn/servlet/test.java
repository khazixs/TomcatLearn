package com.IceCoLa.Learn.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时这是Connection对象管理的一个要点)
        //真正开发中，为了提高效率，都会使用连接池
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "526995");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(conn);
    }
}
