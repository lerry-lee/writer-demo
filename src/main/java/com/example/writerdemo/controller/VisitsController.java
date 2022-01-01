package com.example.writerdemo.controller;

import com.example.writerdemo.response.WriterResponseType;
import com.example.writerdemo.service.VisitsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/01
 */
@RestController
@RequestMapping("/visits")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //处理跨域请求
@Slf4j
public class VisitsController {

    @Autowired
    private VisitsService visitsService;

    /**
     * 单个用户每天的访问只记一次
     */
    @GetMapping(value = "/add")
    public WriterResponseType add(@RequestParam("username") String username) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String vdate = df.format(new Date());
        if (visitsService.add(username, vdate)) {
            log.info(String.format("用户%s在%s访问系统，成功添加一条访问记录", username, vdate));
            return WriterResponseType.success();
        }
        log.info("插入访问记录失败");
        return WriterResponseType.failed("插入访问记录失败", null);
    }


    @GetMapping(value = "/count")
    public WriterResponseType count() {
        Integer count = visitsService.getCount();
        if (count == null) {
            log.info("获取访问量数据失败");
            return WriterResponseType.failed("获取访问量数据失败", null);
        }
        return WriterResponseType.success("", count);
    }
}
