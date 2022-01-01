package com.example.writerdemo.service;

import com.example.writerdemo.entity.User;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface UserService {
    boolean queryByUsername(String username);
    boolean queryByUser(User user);
    String getPassword(String username);
    boolean addUser(User user);
}
