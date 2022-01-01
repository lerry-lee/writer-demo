package com.example.writerdemo.service;

import com.example.writerdemo.entity.User;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface UserService {
    //查询用户名是否存在
    Boolean queryByUsername(String username);

    //查询用户是否存在
    Boolean queryByUser(User user);

    //添加新用户
    Boolean addUser(User user);
}
