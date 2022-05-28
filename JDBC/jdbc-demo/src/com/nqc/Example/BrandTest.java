package com.nqc.Example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.nqc.pojo.Brand;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 品牌数据的增删改查
 *
 */

public class BrandTest {

    /**
     * 查询所有
     * 1、SQL：SELECT * FROM tb_brand
     * 2、参数：不需要
     * 3、结果List<Brand>
     */

    @Test
    public void testSelectAll() throws Exception {
        //1、获取Connection连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2、定义SQL
        String sql = "SELECT * FROM tb_brand";

        //3、获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4、得到查询结果
        ResultSet rs = pstmt.executeQuery();

        //5、将查询结果进行封装
        List<Brand> bands = new ArrayList<>();
        Brand brand = null;
        while (rs.next()){
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            brand = new Brand(id,brandName,companyName,ordered,description,status);
            bands.add(brand);
        }

        System.out.println(bands);

        //6、关闭资源
        rs.close();
        pstmt.close();
        conn.close();
    }

    /**
     * 添加
     * 1、SQL：INSERT INTO tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);
     * 2、参数：不需要
     * 3、结果List<Brand>
     */

    @Test
    public void testAdd() throws Exception {
        String brandName = "测试1";
        String companyName = "测试2";
        int ordered = 1;
        String description = "测试3";
        int status = 1;

        //1、获取Connection连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2、定义SQL
        String sql = "INSERT INTO tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);";

        //3、获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4、设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        //5、执行sql
        int count = pstmt.executeUpdate();
        //6、处理结果
        System.out.println(count > 0);

        //7、关闭资源
        pstmt.close();
        conn.close();
    }

    /**
     * 修改
     * 1、SQL：
         UPDATE tb_brand
     SET brand_name = ?,
     SET company_name = ?,
     SET ordered = ?,
     SET description = ?,
     SET status = ?
     WHERE id = ?

     * 2、参数：需要
     * 3、结果 boolean
     */

    @Test
    public void testUpdate() throws Exception {
        String brandName = "测试修改1";
        String companyName = "测试修改2";
        int ordered = 0;
        String description = "测试修改3";
        int status = 0;
        int id = 4;

        //1、获取Connection连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2、定义SQL
        String sql = "UPDATE tb_brand\n" +
                "     SET brand_name = ?,\n" +
                "     company_name = ?,\n" +
                "     ordered = ?,\n" +
                "     description = ?,\n" +
                "     status = ?\n" +
                "     WHERE id = ?";

        //3、获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4、设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);
        //5、执行sql
        int count = pstmt.executeUpdate();
        //6、处理结果
        System.out.println(count > 0);

        //7、关闭资源
        pstmt.close();
        conn.close();
    }



    /**
     * 修改
     * 1、SQL：
     UPDATE tb_brand
     SET brand_name = ?,
     SET company_name = ?,
     SET ordered = ?,
     SET description = ?,
     SET status = ?
     WHERE id = ?

     * 2、参数：需要
     * 3、结果 boolean
     */

    @Test
    public void testDelete() throws Exception {
        int id = 5;

        //1、获取Connection连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2、定义SQL
        String sql = " DELETE FROM tb_brand WHERE id = ? ";

        //3、获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4、设置参数
        pstmt.setInt(1,id);
        //5、执行sql
        int count = pstmt.executeUpdate();
        //6、处理结果
        System.out.println(count > 0);

        //7、关闭资源
        pstmt.close();
        conn.close();
    }
}
