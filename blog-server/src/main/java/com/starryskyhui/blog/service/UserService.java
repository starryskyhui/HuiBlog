package com.starryskyhui.blog.service;

import com.starryskyhui.blog.pojo.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @author 郑国辉
 */
public interface UserService {
    public int addUser(UserDTO userDTO);
    public int searchUser(String name, String password);
}
