package com.example.writerdemo.service;

import com.example.writerdemo.entity.Messages;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface MessagesService {
    //保存一条消息
    Boolean save(Messages messages);

    //查询所有未读消息
    List<Messages> queryAllNotRead(String username);

    //查询所有消息
    List<Messages> queryAll(String username);

    //获取未读消息数量
    Integer countNotRead(String username);

    //已读某条消息
    Boolean read(Integer id);

    //已读所有未读消息
    Integer readAll(String username);
}
