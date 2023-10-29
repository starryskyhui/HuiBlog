package com.starryskyhui.blog.dao;

import com.starryskyhui.blog.pojo.entity.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author 郑国辉
 */
@Repository
public interface UserDAO {
    public boolean insert(UserDO userDO);

    public int selectByName(String name);

    public int selectByPassword(String password);

    public int selectByNameAndPwd(String name, String password);

    public int update(UserDO userDO);
}
