package com.example.writerdemo.service.impl;

import com.example.writerdemo.entity.Posts;
import com.example.writerdemo.mapper.PostsMapper;
import com.example.writerdemo.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsMapper postsMapper;

    @Override
    public Boolean save(Posts posts) {
        try {
            postsMapper.insert(posts);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Posts> queryAll() {
        try {
            List<Posts> posts = postsMapper.selectAll();
            return posts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Posts> queryAllByAuthor(String author) {
        try {
            List<Posts> posts = postsMapper.selectAllByAuthor(author);
            return posts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Posts> fuzzyQuery(String keyWord, String category, String author) {
        try {
            List<Posts> posts = postsMapper.fuzzyQuery(keyWord, category, author);
            return posts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
