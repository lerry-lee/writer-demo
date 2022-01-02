package com.example.writerdemo.controller;

import com.example.writerdemo.entity.Posts;
import com.example.writerdemo.response.WriterResponseType;
import com.example.writerdemo.service.PostsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@RestController
@RequestMapping("/posts")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //处理跨域请求
@Slf4j
public class PostsController {

    private final static String ContentType = "application/x-www-form-urlencoded";

    @Autowired
    private PostsService postsService;

    /**
     * 保存发布的帖子
     */
    @PostMapping(value = "/save", consumes = ContentType)
    public WriterResponseType save(@RequestParam("author") String author,
                                   @RequestParam("title") String title,
                                   @RequestParam("content") String content,
                                   @RequestParam("category") String category) {
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        Posts posts = Posts.builder()
                .author(author)
                .title(title)
                .content(content)
                .category(category)
                .sdate(df.format(new Date()))
                .totalComments(0)
                .build();
        Boolean result = postsService.save(posts);
        if (result == null) {
            log.info(String.format("作者%s发布的帖子\"%s\"保存时发生异常", author, title));
            return WriterResponseType.failed("保存帖子时发生异常", null);
        } else if (result) {
            log.info(String.format("作者%s发布的帖子\"%s\"保存成功", author, title));
            return WriterResponseType.success();
        }
        log.info(String.format("作者%s发布的帖子\"%s\"保存失败", author, title));
        return WriterResponseType.failed("保存帖子失败", null);
    }


    /**
     * 获取所有帖子
     */
    @GetMapping(value = "/query_all")
    public WriterResponseType queryAll() {
        List<Posts> posts = postsService.queryAll();
        if (posts == null) {
            log.info("查询帖子时发生异常");
            return WriterResponseType.failed("查询帖子时发生异常", null);
        }
        return WriterResponseType.success("", posts);
    }

    /**
     * 获取某个用户的所有帖子
     */
    @GetMapping(value = "/query_all_by_author")
    public WriterResponseType queryAllByAuthor(@RequestParam("author") String author) {
        List<Posts> posts = postsService.queryAllByAuthor(author);
        if (posts == null) {
            log.info(String.format("查询用户%s的帖子时发生异常", author));
            return WriterResponseType.failed("查询帖子时发生异常", null);
        }
        return WriterResponseType.success("", posts);
    }

    /**
     * 模糊查询
     */
    @GetMapping(value = "/fuzzy_query")
    public WriterResponseType fuzzyQuery(@RequestParam(value = "category", required = false) String category,
                                         @RequestParam(value = "author", required = false) String author,
                                         @RequestParam(value = "key_words", required = false) String keyWords) {
        if (category != null) category = category.equalsIgnoreCase("all") ? null : category;
        if (author != null) author = author.equalsIgnoreCase("all") ? null : author;
        if (keyWords != null) keyWords = keyWords.equals("") ? null : keyWords;
        List<Posts> posts = postsService.fuzzyQuery(keyWords, category, author);
        if (posts == null) {
            log.info("查询帖子时发生异常");
            return WriterResponseType.failed("查询帖子时发生异常", null);
        }
        return WriterResponseType.success("", posts);
    }
}
