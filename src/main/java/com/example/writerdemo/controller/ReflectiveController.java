package com.example.writerdemo.controller;

import com.example.writerdemo.controller.vo.Score;
import com.example.writerdemo.entity.Reflective;
import com.example.writerdemo.response.LayuiResponseType;
import com.example.writerdemo.response.WriterResponseType;
import com.example.writerdemo.service.ReflectiveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@RestController
@RequestMapping("/reflective")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //处理跨域请求
@Slf4j
public class ReflectiveController {

    private final static String ContentType = "application/x-www-form-urlencoded";

    @Autowired
    private ReflectiveService reflectiveService;

    /**
     * 保存一次评分版本
     */
    @PostMapping(value = "/save", consumes = ContentType)
    public WriterResponseType save(@RequestParam("username") String username,
                                   @RequestParam("title") String title,
                                   @RequestParam("content") String content,
                                   @RequestParam("self") Integer self,
                                   @RequestParam("comparison") Integer comparison,
                                   @RequestParam("summary") Integer summary,
                                   @RequestParam("automatic") Integer automatic) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Reflective reflective = Reflective.builder()
                .username(username)
                .title(title)
                .content(content)
                .self(self)
                .comparison(comparison)
                .summary(summary)
                .automatic(automatic)
                .sdate(df.format(new Date()))
                .build();
        Boolean result = reflectiveService.add(reflective);
        if (result) {
            log.info(String.format("用户%s本次写作报告评分版本保存成功", username));
            return WriterResponseType.success();
        }
        return WriterResponseType.failed();
    }

    /**
     * 获取所有写作版本，展示评分
     */
    @GetMapping(value = "/query_all_by_username_with_limit")
    public LayuiResponseType queryAllByUsernameWithLimit(@RequestParam("username") String username,
                                                         @RequestParam(value = "page") Integer page,
                                                         @RequestParam(value = "limit") Integer limit) {

        List<Reflective> reflectives = reflectiveService.queryAllByUsername(username, limit, (page - 1) * limit);
        if (reflectives == null) {
            return LayuiResponseType.create(1, "查询异常", 0, null);
        }
        Integer total = reflectiveService.getTotal(username);
        if (total == null) {
            return LayuiResponseType.create(1, "查询异常", 0, null);
        }
        log.info(String.format("成功获取用户%s的%d条历史写作记录（总共%d条）", username, reflectives.size(), total));
        return LayuiResponseType.create(0, "", total, reflectives);
    }

    /**
     * 获取所有写作版本
     */
    @GetMapping(value = "/query_all_by_username")
    public LayuiResponseType queryAllByUsername(@RequestParam("username") String username) {

        List<Reflective> reflectives = reflectiveService.queryAllByUsername(username);
        if (reflectives == null) {
            return LayuiResponseType.create(1, "查询异常", 0, null);
        }
        Integer total = reflectiveService.getTotal(username);
        if (total == null) {
            return LayuiResponseType.create(1, "查询异常", 0, null);
        }
        List<Score> scores = reflectives.stream().map(reflective -> {
            Score score = new Score();
            BeanUtils.copyProperties(reflective, score);
            return score;
        }).collect(Collectors.toList());
        log.info(String.format("成功获取用户%s的%d条历史写作记录（总共%d条）", username, scores.size(), total));
        return LayuiResponseType.create(0, "", total, scores);
    }

    /**
     * 模糊查询，根据title和时间段
     */
    @GetMapping(value = "/fuzzy_query")
    public LayuiResponseType fuzzyQuery(@RequestParam("username") String username,
                                        @RequestParam("title") String title,
                                        @RequestParam("start_date") String startDate,
                                        @RequestParam("end_date") String endDate,
                                        @RequestParam("page") Integer page,
                                        @RequestParam("limit") Integer limit) {
        //判空
        if (title.isEmpty()) {
            return LayuiResponseType.create(1, "title不能为空", 0, null);
        }
        if (startDate.isEmpty() || endDate.isEmpty()) {
            return LayuiResponseType.create(1, "date不能为空", 0, null);
        }
        List<Reflective> reflectives = reflectiveService.fuzzyQueryAllByUsername(username, title, startDate, endDate, limit, (page - 1) * limit);
        if (reflectives == null) {
            return LayuiResponseType.create(1, "查询异常", 0, null);
        }
        Integer total = reflectiveService.getTotalBySearch(username, title, startDate, endDate);
        if (total == null) {
            return LayuiResponseType.create(1, "查询异常", 0, null);
        }
        log.info(String.format("成功获取用户%s的%d条历史写作记录（总共%d条）", username, reflectives.size(), total));
        return LayuiResponseType.create(0, "", total, reflectives);
    }

    /**
     * 删除一条记录，根据id
     */
    @PostMapping(value = "/delete", consumes = ContentType)
    public WriterResponseType delete(@RequestParam("id") Integer id) {
        Boolean result = reflectiveService.delete(id);
        if (result == null) {
            log.info(String.format("删除时reflective表中id为%d的数据时发生异常", id));
            return WriterResponseType.failed("删除异常", null);
        } else if (result) {
            log.info(String.format("删除时reflective表中id为%d的数据成功", id));
            return WriterResponseType.success();
        }
        log.info(String.format("删除时reflective表中id为%d的数据失败", id));
        return WriterResponseType.failed();
    }
}
