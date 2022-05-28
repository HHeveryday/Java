package com.nqc.mapper;


import com.nqc.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);

    /**
     * 条件查询
     * 参数接收
     *  1、散装参数：如果方法中有多个参数，需要使用@Param("SQL参数站位符名称")
     *  2、对象参数
     *  3、map集合

     */
//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

//    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加数据到数据库
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改数据
     */
    int update(Brand brand);

    /**
     * 删除单条数据
     */
    void deletById(int id);

    /**
     * 根据id批量删除
     * @param id
     */
    void deletByIds(@Param("ids") int[] ids);
}
