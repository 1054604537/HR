package com.andy.dao;

import com.andy.model.User;

import java.util.List;

/**
 * Created by 10546 on 2018/4/20.
 */
public interface UserMapper {
    boolean addUser(User user);
    List<User> allUser();//全部用户
    User findUser(User user);
    User fingUserByName(String name);
    User findUserByResume(User user);
    boolean updatepass(User user);//修改密码
    User findUserToResumByName(User user);
}
