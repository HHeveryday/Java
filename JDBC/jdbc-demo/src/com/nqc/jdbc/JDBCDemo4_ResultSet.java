package com.nqc.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ResultSet的API
 */
public class JDBCDemo4_ResultSet {
    @Test
    public void testDQL() throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/dbtest?useSSL=false";
        String username = "root";
        String password = "abc123";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3、获取Statement
        Statement stmt = conn.createStatement();

        //4、执行sql语句
        String sql = "select * from dept";

        ResultSet rs = stmt.executeQuery(sql);

        //5、遍历输出集合中的结果，使用next()
        while (rs.next()){
            int id = rs.getInt(1);
            String dname = rs.getString(2);
            String loc = rs.getString(3);
            System.out.print(id + "\t");
            System.out.print(dname + "\t");
            System.out.print(loc);
            System.out.println();
        }
        //6、关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }

}
