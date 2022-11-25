package com.example.demo.service;

import java.util.List;

import com.example.demo.mapper.user_accountMapper;

import javafx.print.PrintColor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.user_account;

@Service
public class user_accountService {
    
    @Autowired
    private user_accountMapper uaMapper;

    /*
     * 功能：用来查询用户账户表中，是否已经存在该手机号码
     * 返回：1已经有，提示找回密码；0没有，可以注册
     */
    public int ifHavePhone_number(String phone_number)
    {
        List<user_account> ualist = uaMapper.findUserByPhone_number(phone_number);
        if(ualist.size() == 0)
        {
            return 0;
        }
        return 1;
    }

    /*
     * 功能：用来查询用户账户表中，是否已经存在该用户名
     * 返回：1已经有，提示重新输入；0没有，可以注册
     */
    public int ifHaveUsername(String username)
    {
        List<user_account> ualist = uaMapper.findUserByUsername(username);
        if(ualist.size() == 0)
        {
            return 0;
        }
        return 1;
    }

    /*
     * 功能：用来向用户账户表中插入新用户，这里的用户type为1，客户类别
     * 返回：1插入成功；0插入失败
     */
    public int insertUser(user_account ua)
    {
        return uaMapper.insert(ua);
    }

    /*
     * 功能：传入用户名和密码之后，确认是否正确，正确返回账户类型
     * 返回：0,代表管理账户；1代表用户账户；401代表用户名不存在；402代表密码不正确,403其他错误
     */
    public int login(String username, String password)
    {
        List<user_account> ualist = uaMapper.findUserByUsername(username);
        if(ualist.size() == 0)
        {
            //此时用户名不存在
            return 401;
        }
        else if(ualist.size() != 1){
            return 403;
        }
        else{
            if(!ualist.get(0).getPassword().equals(password) )
            {
                return 402;
            }
        }
        int type_ = ualist.get(0).getType();
        return type_;
    }

    /*
     * 功能：传入用户名和密码之后，确认是否正确，正确返回账户类型
     * 返回：0,代表管理账户；1代表用户账户；401代表用户名不存在；402代表密码不正确,403其他错误
     */
    public List<user_account> getAccount()
    {
        List<user_account> ualist = uaMapper.findAllUser();
        
        return ualist;
    }
}
