package com.example.writerdemo.controller;

import com.example.writerdemo.service.VisitsService;
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
public class VisitsController {

    @Autowired
    private VisitsService visitsService;

    /**
     * 单个用户每天的访问只记一次
     */
    @GetMapping(value = "/visits")
    public int addVisits(@RequestParam("username") String username) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String vdate = df.format(new Date());
        if (visitsService.add(username, vdate)) {
            return 1;
        }
        return 0;
    }

}
