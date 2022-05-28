package com.nqc.mapper;

import com.nqc.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();



    User selectById(int id);
}
