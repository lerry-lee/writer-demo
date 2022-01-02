package com.example.writerdemo.controller;

import com.example.writerdemo.entity.Contact;
import com.example.writerdemo.response.WriterResponseType;
import com.example.writerdemo.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@RestController
@RequestMapping("/contact")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //处理跨域请求
@Slf4j
public class ContactController {
    private final static String ContentType = "application/x-www-form-urlencoded";

    @Autowired
    private ContactService contactService;

    /**
     * 保存用户的建议
     */
    @PostMapping(value = "/save", consumes = ContentType)
    public WriterResponseType save(@RequestParam("username") String username,
                                   @RequestParam("name") String name,
                                   @RequestParam("email") String email,
                                   @RequestParam("comments") String comments) {
        Contact contact = Contact.builder()
                .username(username)
                .name(name)
                .comments(comments)
                .email(email)
                .build();
        Boolean result = contactService.save(contact);
        if (result == null || !result) {
            log.info(String.format("用户%s的建议保存失败", username));
            return WriterResponseType.failed("用户建议保存失败", null);
        }
        log.info(String.format("用户%s的建议保存成功", username));
        return WriterResponseType.success();
    }
}
