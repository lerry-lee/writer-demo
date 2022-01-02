package com.example.writerdemo.controller;

import com.example.writerdemo.entity.Report;
import com.example.writerdemo.response.WriterResponseType;
import com.example.writerdemo.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/01
 */
@RestController
@RequestMapping("/report")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //处理跨域请求
@Slf4j
public class ReportController {
    private final static String ContentType = "application/x-www-form-urlencoded";

    @Autowired
    private ReportService reportService;

    /**
     * 查询当前用户的上次写作存档
     */
    @GetMapping(value = "/query")
    public WriterResponseType query(@RequestParam("username") String username) {
        String content = reportService.queryContentByUsername(username);
        //如果查询异常
        if (content == null) {
            log.info(String.format("查询用户%s的报告内容时发生异常", username));
            return WriterResponseType.failed();
        }
        log.info(String.format("查询用户%s的报告成功，内容为\"%s\"", username, content));
        return WriterResponseType.success("", content);
    }

    /**
     * 保存写作编辑
     */
    @PostMapping(value = "/save", consumes = ContentType)
    public WriterResponseType save(@RequestParam("username") String username,
                                   @RequestParam("content") String content) {
        Report report = Report.builder().username(username).content(content).build();
        Boolean result = reportService.save(report);
        if (result == null) {
            log.info(String.format("保存用户%s的报告内容时发生异常", username));
            return WriterResponseType.failed("保存异常，请检查后台", null);
        } else if (result) {
            log.info(String.format("用户%s的报告保存成功", username));
            return WriterResponseType.success();
        }
        return WriterResponseType.failed();
    }

    /**
     * 调用API分析文章 todo
     */
    @PostMapping(value = "analyse", consumes = ContentType)
    public WriterResponseType analyse(@RequestParam("content") String content,
                                      @RequestParam("type") int type) {
        return WriterResponseType.success("", "good job");
    }
}
