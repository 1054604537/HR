package com.andy.biz;

import com.andy.model.User;

import java.util.List;

/**
 * Created by 10546 on 2018/4/20.
 */
public interface UserService {
    boolean addUser(User user);
    User getUser(User user);//判断重复
    List<User> allUser();
    User findUser(User user);
    User fingUserByName(String name);
    User findUserByResume(User user);
    boolean updatepass(User user);//修改密码
    User findUserToResumByName(User user);
    List<User> userToMassage(User user);//用户的邀请信息 UID
    List<User> findUserById(int uid);
    List<User> findUserByResume2(int uid);//uid 查找简历
}
