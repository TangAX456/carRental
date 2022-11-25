package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Entity.user_account;

@Mapper
public interface user_accountMapper {
    
    @Select("select * from user_account where user_name = #{user_name}")
    List<user_account> findUserByUsername(String user_name);

    @Select("select * from user_account where phone_number = #{phonenumber}")
    List<user_account> findUserByPhone_number(String phonenumber);

    @Insert("insert into user_account(user_name, password, phone_number, type) values(#{user_name},#{password},#{phone_number},#{type})")
    int insert(user_account ua);

    @Select("select * from user_account")
    List<user_account> findAllUser();

}