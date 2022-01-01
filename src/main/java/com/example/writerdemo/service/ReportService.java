package com.example.writerdemo.service;

import com.example.writerdemo.entity.Report;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface ReportService {
    //保存报告
    Boolean save(Report report);

    //查询报告内容，根据用户名
    String queryContentByUsername(String username);
}
