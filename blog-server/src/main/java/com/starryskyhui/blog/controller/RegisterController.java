package com.starryskyhui.blog.controller;

import com.starryskyhui.blog.pojo.dto.UserDTO;
import com.starryskyhui.blog.pojo.vo.UserVO;
import com.starryskyhui.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 郑国辉
 */
@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @GetMapping("/blog/signIn/{name}/{password}")
    public int signIn(@PathVariable("name") String name, @PathVariable("password") String password) {
        return userService.searchUser(name, password);
    }

    @PostMapping("/blog/signUp")
    public int signUp(@RequestBody UserVO userVO) {
        if (userVO == null) {
            return 0;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userVO.getUserName());
        userDTO.setPassword(userVO.getPassword());
        userDTO.setBirth(userVO.getBirth());
        userDTO.setGender(userVO.getGender());
        userDTO.setPhoneNum(userVO.getPhoneNum());
        userDTO.setMail(userVO.getMail());

        return userService.addUser(userDTO);
    }
}
