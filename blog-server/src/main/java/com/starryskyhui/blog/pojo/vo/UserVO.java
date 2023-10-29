package com.starryskyhui.blog.pojo.vo;

import lombok.Data;

/**
 * @author 郑国辉
 */
@Data
public class UserVO {
    private Integer id;
    private String userName;
    private String password;
    private Integer gender;
    private String birth;
    private String phoneNum;
    private String mail;
}
