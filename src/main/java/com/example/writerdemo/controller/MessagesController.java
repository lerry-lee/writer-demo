package com.example.writerdemo.controller;

import com.example.writerdemo.entity.Messages;
import com.example.writerdemo.response.WriterResponseType;
import com.example.writerdemo.service.MessagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@RestController
@RequestMapping("/messages")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //处理跨域请求
@Slf4j
public class MessagesController {

    private final static String ContentType = "application/x-www-form-urlencoded";

    @Autowired
    private MessagesService messagesService;

    /**
     * 获取未读消息数量
     */
    @GetMapping(value = "/count_not_read")
    public WriterResponseType countNotRead(@RequestParam("username") String username) {
        Integer count = messagesService.countNotRead(username);
        if (count == null) {
            log.info(String.format("获取用户%s的未读消息数量失败", username));
            return WriterResponseType.failed("获取未读消息数量失败", null);
        }
        log.info(String.format("获取用户%s的未读消息数量为%d条", username, count));
        return WriterResponseType.success("", count);
    }

    /**
     * 保存一次消息
     */
    @PostMapping(value = "/save", consumes = ContentType)
    public WriterResponseType saveMessages(@RequestParam("username") String commentator,
                                           @RequestParam("author") String author,
                                           @RequestParam("sid") Integer sid,
                                           @RequestParam("title") String title,
                                           @RequestParam("comment") String comment) throws UnsupportedEncodingException {
        title = URLDecoder.decode(title, "UTF-8");
        String msg = commentator + "评论了你的帖子《" + title + "》";
        Messages messages = Messages.builder()
                .sid(sid)
                .comment(comment)
                .message(msg)
                .username(author)
                .build();
        Boolean result = messagesService.save(messages);
        if (result == null || !result) {
            log.info(String.format("用户%s评论%s的帖子《%s》后，发送消息给作者失败", commentator, author, title));
            return WriterResponseType.failed("发送消息失败", null);
        }
        log.info(String.format("用户%s评论%s的帖子《%s》后，发送消息给作者成功", commentator, author, title));
        return WriterResponseType.success();
    }

    /**
     * 列出所有未读消息
     */
    @GetMapping(value = "/query_all_not_read")
    public WriterResponseType queryAllNotRead(@RequestParam("username") String username) {
        List<Messages> messages = messagesService.queryAllNotRead(username);
        if (messages == null) {
            log.info(String.format("获取用户%s的消息失败", username));
            return WriterResponseType.failed("获取消息失败", null);
        }
        log.info(String.format("获取用户%s的消息共%d条", username, messages.size()));
        return WriterResponseType.success(null, messages);
    }

    /**
     * 已读一条消息
     */
    @PostMapping(value = "/read", consumes = ContentType)
    public WriterResponseType read(@RequestParam("id") Integer id) {
        Boolean result = messagesService.read(id);
        if (result == null || !result) {
            log.info(String.format("消息%d标记为已读失败", id));
            return WriterResponseType.failed("消息标记为已读失败", null);
        }
        log.info(String.format("消息%d标记为已读成功", id));
        return WriterResponseType.success();
    }

    /**
     * 已读所有未读消息
     */
    @PostMapping(value = "/read_all", consumes = ContentType)
    public WriterResponseType readAll(@RequestParam("username") String username) {
        Integer result = messagesService.readAll(username);
        if (result == null) {
            log.info(String.format("用户%s的未读消息标记为已读失败", username));
            return WriterResponseType.failed("消息标记为已读失败", null);
        }
        log.info(String.format("成功将用户%s的%d条未读消息标记为已读", username, result));
        return WriterResponseType.success();
    }
}
