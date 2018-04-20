package com.andy.biz.impl;

import com.andy.biz.UserService;
import com.andy.dao.UserMapper;
import com.andy.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/20.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        userMapper.addUser(user);
        return true;
    }

    @Override
    public List<User> allUser() {
        List<User> list=userMapper.allUser();
        if (list.size()!=0){
            return list;
        }
        return null;
    }

    @Override
    public User findUser(User user) {
        User user1=userMapper.findUser(user);
        return user1;
    }

    @Override
    public User fingUserByName(String name) {
        return userMapper.fingUserByName(name);
    }
}
