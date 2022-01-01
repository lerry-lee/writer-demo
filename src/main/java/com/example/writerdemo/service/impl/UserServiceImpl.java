package com.example.writerdemo.service.impl;

import com.example.writerdemo.entity.User;
import com.example.writerdemo.mapper.UserMapper;
import com.example.writerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean queryByUsername(String username) {
        return userMapper.selectByUsername(username) != null;
    }

    @Override
    public boolean queryByUser(User user) {
        return userMapper.selectByUser(user) != null;
    }

    @Override
    public String getPassword(String username) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
