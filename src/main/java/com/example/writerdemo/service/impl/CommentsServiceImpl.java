package com.example.writerdemo.service.impl;

import com.example.writerdemo.entity.Comments;
import com.example.writerdemo.mapper.CommentsMapper;
import com.example.writerdemo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public Boolean save(Comments comments) {
        try {
            commentsMapper.insert(comments);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Comments> queryAllBySid(Integer sid) {
        try {
            List<Comments> comments = commentsMapper.selectBySid(sid);
            return comments;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
