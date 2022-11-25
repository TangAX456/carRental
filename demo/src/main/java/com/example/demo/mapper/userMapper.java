package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Entity.login_user;

@Mapper
public interface userMapper {
    
    @Select("select * from login_user")
    List<login_user> findAll();
}
