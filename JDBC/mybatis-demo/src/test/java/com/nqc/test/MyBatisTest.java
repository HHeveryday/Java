package com.nqc.test;

import com.nqc.mapper.BrandMapper;
import com.nqc.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取mapper代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行sql
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5、关闭资源
        sqlSession.close();
    }


    @Test
    public void testSelectById() throws IOException {
        int id = 1;
        //1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取mapper代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行sql
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);


        //5、关闭资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        Map map = new HashMap();
//        map.put("status",status);
        map.put("companyName", companyName);
//        map.put("brandName",brandName);

        //1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取mapper代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行sql
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5、关闭资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);


        //1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取mapper代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行sql
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5、关闭资源
        sqlSession.close();
    }

    @Test
    public void add() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        Integer ordered = 100;
        String description = "测试";


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);


        //1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3、获取mapper代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行sql
        brandMapper.add(brand);

        //5、提交事务,或者在第二步添加参数ture
//        sqlSession.commit();

        //6、关闭资源
        sqlSession.close();
    }

    @Test
    public void add2() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        Integer ordered = 100;
        String description = "测试";


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);


        //1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3、获取mapper代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行sql
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //5、提交事务,或者在第二步添加参数ture
//        sqlSession.commit();

        //6、关闭资源
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为，123";
        Integer ordered = 200;
        String description = "测试2";
        int id = 5;


        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
//        brand.setDescription(description);
        brand.setId(id);


        //1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3、获取mapper代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行sql
        int count = brandMapper.update(brand);
        System.out.println(count);


        //5、提交事务,或者在第二步添加参数ture
//        sqlSession.commit();

        //6、关闭资源
        sqlSession.close();
    }

    @Test
    public void deleteById() throws IOException {
        int id = 5;

        //1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3、获取mapper代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行sql
        brandMapper.deletById(id);


        //5、提交事务,或者在第二步添加参数ture
//        sqlSession.commit();

        //6、关闭资源
        sqlSession.close();
    }

    @Test
    public void deleteByIds() throws IOException {
        int[] ids = {4,6};

        //1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3、获取mapper代理
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行sql
        brandMapper.deletByIds(ids);


        //5、提交事务,或者在第二步添加参数ture
//        sqlSession.commit();

        //6、关闭资源
        sqlSession.close();
    }
}
