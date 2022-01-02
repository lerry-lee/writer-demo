package com.example.writerdemo.service;

import com.example.writerdemo.entity.Comments;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface CommentsService {
    //保存一次评论
    Boolean save(Comments comments);

    //查询某个帖子的所有评论
    List<Comments> queryAllBySid(Integer sid);
}
