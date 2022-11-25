package com.example.demo.Entity;

import lombok.Data;

@Data
public class user_account {
    private Integer user_id;
    private String phone_number;
    private String user_name;
    private String password;
    private Integer type;
}
