package com.example.writerdemo.service;

import com.example.writerdemo.entity.Posts;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface PostsService {
    //保存帖子
    Boolean save(Posts posts);

    //查找所有帖子
    List<Posts> queryAll();

    //查找某个作者的所有帖子
    List<Posts> queryAllByAuthor(String author);

    //模糊查询
    List<Posts> fuzzyQuery(String keyWord, String category, String author);
}
