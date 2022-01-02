package com.example.writerdemo.controller;

import com.example.writerdemo.entity.Comments;
import com.example.writerdemo.response.WriterResponseType;
import com.example.writerdemo.service.CommentsService;
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
@RequestMapping("/comments")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //处理跨域请求
@Slf4j
public class CommentsController {

    private final static String ContentType = "application/x-www-form-urlencoded";

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private PostsService postsService;

    /**
     * 保存一次评论
     */
    @PostMapping(value = "/save", consumes = ContentType)
    public WriterResponseType save(@RequestParam("commentator") String commentator,
                                   @RequestParam("sid") Integer sid,
                                   @RequestParam("comment") String comment,
                                   @RequestParam("niming") Integer niming) {
        commentator = niming == 1 ? "匿名用户" : commentator;
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        Comments comments = Comments.builder()
                .comment(comment)
                .sid(sid)
                .commentator(commentator)
                .cdate(df.format(new Date()))
                .build();
        Boolean result = commentsService.save(comments);
        if (result == null) {
            log.info(String.format("用户%s评论帖子%d时发生异常", commentator, sid));
            return WriterResponseType.failed("评论发生异常", null);
        } else if (result) {
            //评论数+1
            Boolean flag = postsService.updateCommentsByOne(sid);
            if (flag == null || !flag) {
                log.info(String.format("帖子%d的评论数增加失败", sid));
                return WriterResponseType.failed("评论失败", null);
            }
            log.info(String.format("用户%s评论帖子%d成功", commentator, sid));
            return WriterResponseType.success();
        }
        log.info(String.format("用户%s评论帖子%d失败", commentator, sid));
        return WriterResponseType.failed("评论失败", null);
    }

    /**
     * 获取某个帖子的所有评论
     */
    @GetMapping(value = "/query_all")
    public WriterResponseType queryAll(@RequestParam("sid") Integer sid) {
        List<Comments> comments = commentsService.queryAllBySid(sid);
        if (comments == null) {
            log.info(String.format("查询帖子%d时发生异常", sid));
            return WriterResponseType.failed("查询帖子时发生异常", null);
        }
        return WriterResponseType.success("", comments);
    }
}
