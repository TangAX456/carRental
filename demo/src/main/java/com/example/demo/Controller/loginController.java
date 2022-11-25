package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.user_account;
import com.example.demo.service.user_accountService;

@RequestMapping("/login")
@RestController
public class loginController {

    @Autowired
    user_accountService uaService;

    @PostMapping("/regist")
    public Integer regist(@RequestBody user_account ua)
    {
        if(ua.getUser_name() != null && ua.getPassword() != null && ua.getPhone_number() != null){
            ua.setType(1);
            return uaService.insertUser(ua);
        }
        return 500;
    }

    @PostMapping("/checkUsername")
    public Integer checkUsername(@RequestBody user_account ua)
    {
        if(ua.getUser_name() != null){
            return uaService.ifHaveUsername(ua.getUser_name());
        }
        return 500;
    }

    @PostMapping("/checkPhoneNumber")
    public Integer checkPhoneNumber(@RequestBody user_account ua)
    {
        
        if(ua.getPhone_number() != null){
            return uaService.ifHavePhone_number(ua.getPhone_number());
        }
        return 500;
    }

    @PostMapping("/Lo")
    public Integer login(@RequestBody user_account ua)
    {
        
        if(ua.getUser_name() != null && ua.getPassword() != null){
            return uaService.login(ua.getUser_name(), ua.getPassword());
        }
        return 500;
    }

    @GetMapping("/getUser")
    public List<user_account> getUser()
    {
        return uaService.getAccount();
    }

}