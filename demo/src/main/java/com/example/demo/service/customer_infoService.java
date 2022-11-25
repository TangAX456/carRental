package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.customer_infoMapper;
import com.example.demo.Entity.customer_info;

@Service
public class customer_infoService{
    
    @Autowired
    private customer_infoMapper cimapper;

    public int save(customer_info ci){
        if(ci.getId() == null) {
            //没有id表示为新增，有则为更新？？
            return cimapper.insert(ci);
        }
        else{
            //否则为更新
            int i = cimapper.update(ci);
            return i;
        }
    }

    public int deleteById(Integer id) {
        return cimapper.deleteById(id);
    }

    

}