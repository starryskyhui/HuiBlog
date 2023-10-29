package com.starryskyhui.blog.pojo.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String password;
    private Integer gender;
    private String birth;
    private String phoneNum;
    private String mail;
}
