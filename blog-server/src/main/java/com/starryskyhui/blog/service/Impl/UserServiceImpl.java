package com.starryskyhui.blog.service.Impl;


import com.starryskyhui.blog.dao.UserDAO;
import com.starryskyhui.blog.pojo.dto.UserDTO;
import com.starryskyhui.blog.pojo.entity.UserDO;
import com.starryskyhui.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public int addUser(UserDTO userDTO) {
        // 用户名或者密码为空
        if (userDTO == null || userDTO.getName() == null || userDTO.getPassword() == null) {
            return 1;
        }

        // 用户名已存在
        int res = userDAO.selectByName(userDTO.getName());
        if (res != 0) {
            return 2;
        }
        UserDO userDO = new UserDO();
        userDO.setName(userDTO.getName());
        userDO.setPassword(userDTO.getPassword());
        if (!"".equals(userDTO.getBirth())) {
            userDO.setBirth(userDTO.getBirth());
        }
        userDO.setPhoneNum(userDTO.getPhoneNum());
        userDO.setMail(userDTO.getMail());
        userDO.setGender(userDTO.getGender());

        if (userDAO.insert(userDO)) {
            return 0;
        } else {
            return 3;
        }
    }

    @Override
    public int searchUser(String name, String password) {
        if (name == null || password == null) {
            return 0;
        }
        int res = userDAO.selectByNameAndPwd(name, password);
        if (res == 1) {
            return 0;
        }
        if (userDAO.selectByName(name) == 1 || userDAO.selectByPassword(password) == 1) {
            return 1;
        } else {
            return 2;
        }
    }
}
