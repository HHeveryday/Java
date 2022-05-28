package com.nqc.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Statement的API详解
 */
public class JDBCDemo3 {
    @Test
    public void testDML() throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/dbtest?useSSL=false";
        String username = "root";
        String password = "abc123";
        Connection conn = DriverManager.getConnection(url,username,password);


        Statement stmt = null;
        try {
            //开启事务
            conn.setAutoCommit(false);

            //3、定义sql
            String sql1 = "update dept set loc = '测试1' where id = 10";
            //4、获取执行sql的对象 Statement
            stmt = conn.createStatement();
            //5、执行sql语句
            int count1 = stmt.executeUpdate(sql1);//返回执行DML语句，受影响的行数
            //6、处理结果
//            System.out.println(count1);
            if (count1 > 0){
                System.out.println("修改成功~");
            }else {
                System.out.println("修改失败~");
            }
            //提交事务
            conn.commit();
        } catch (Exception throwables) {
            //回滚事务
            conn.rollback();
            throwables.printStackTrace();
        }

        //7、释放资源
        stmt.close();
        conn.close();
    }

    @Test
    public void testDDL() throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/dbtest?useSSL=false";
        String username = "root";
        String password = "abc123";
        Connection conn = DriverManager.getConnection(url,username,password);


        Statement stmt = null;
        try {
            //开启事务
            conn.setAutoCommit(false);

            //3、定义sql
            String sql1 = "drop database if exists db2";
            //4、获取执行sql的对象 Statement
            stmt = conn.createStatement();
            //5、执行sql语句
            int count1 = stmt.executeUpdate(sql1);//返回执行DML语句，受影响的行数
            //6、处理结果
//            System.out.println(count1);
//            if (count1 > 0){
//                System.out.println("修改成功~");
//            }else {
//                System.out.println("修改失败~");
//            }
            System.out.println(count1);
            //提交事务
            conn.commit();
        } catch (Exception throwables) {
            //回滚事务
            conn.rollback();
            throwables.printStackTrace();
        }

        //7、释放资源
        stmt.close();
        conn.close();
    }
}
