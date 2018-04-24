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
    User findUserByResume(User user);//uid 查找简历
    boolean updatepass(User user);//修改密码
    User findUserToResumByName(User user);
    List<User> findUserById(int uid);
    List<User> userToMassage(User user);//用户的邀请信息 UID

    List<User> findUserByResume2(int uid);//uid 查找简历
}
