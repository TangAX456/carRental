package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Entity.customer_info;

@Mapper
public interface customer_infoMapper {
    
    @Select("select * from customer_info")
    List<customer_info> findAll();

    @Insert("insert into customer_info(name, phone_number) values(#{name},#{phone_number})")
    int insert(customer_info ci);

    int update(customer_info ci);

    int deleteById(@Param("id") Integer id);

    @Select("select count(*) from customer_info")
    int findPageTotal();

    @Select("select * from customer_info limit #{pageNum}, #{pageSize}")
    List<customer_info> findPage(@Param("pageNum") Integer num, @Param("pageSize") Integer size);

}
