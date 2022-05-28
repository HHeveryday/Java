package com.nqc.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/dbtest?useSSL=false";
        String username = "root";
        String password = "abc123";
        Connection conn = DriverManager.getConnection(url,username,password);

        //3、定义sql
        String sql = "update dept set loc = '测试' where id = 10";

        //4、获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //5、执行sql语句
        int count = stmt.executeUpdate(sql);//返回受影响的行数

        //6、处理结果
        System.out.println(count);

        //7、释放资源
        stmt.close();
        conn.close();
    }
}
