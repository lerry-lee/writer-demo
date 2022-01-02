package com.example.writerdemo.service;

import com.example.writerdemo.entity.Contact;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface ContactService {
    //插入一条用户反馈记录
    Boolean save(Contact contact);
}
