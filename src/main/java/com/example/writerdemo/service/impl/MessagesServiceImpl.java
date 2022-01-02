package com.example.writerdemo.service.impl;

import com.example.writerdemo.entity.Messages;
import com.example.writerdemo.mapper.MessagesMapper;
import com.example.writerdemo.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessagesMapper messagesMapper;

    @Override
    public Boolean save(Messages messages) {
        try {
            messagesMapper.insert(messages);
            return true;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Messages> queryAllNotRead(String username) {
        try {
            List<Messages> messages = messagesMapper.selectAllNotRead(username);
            return messages;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Messages> queryAll(String username) {
        try {
            List<Messages> messages = messagesMapper.selectAll(username);
            return messages;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer countNotRead(String username) {
        try {
            int row = messagesMapper.countNotRead(username);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean read(Integer id) {
        try {
            int row = messagesMapper.readMessage(id);
            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer readAll(String username) {
        try {
            int row = messagesMapper.readAllMessageByUsername(username);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
