package com.starryskyhui.blog.pojo.entity;

import lombok.Data;

/**
 * @author 郑国辉
 */
@Data
public class UserDO {
    private Integer id;
    private String name;
    private String password;
    private Integer gender;
    private String birth;
    private String phoneNum;
    private String mail;
}
