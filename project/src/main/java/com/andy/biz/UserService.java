package com.andy.biz;

import com.andy.model.User;

import java.util.List;

/**
 * Created by 10546 on 2018/4/20.
 */
public interface UserService {
    boolean addUser(User user);
    List<User> allUser();
    User findUser(User user);
    User fingUserByName(String name);
    User findUserByResume(User user);
    boolean updatepass(User user);//修改密码
}
