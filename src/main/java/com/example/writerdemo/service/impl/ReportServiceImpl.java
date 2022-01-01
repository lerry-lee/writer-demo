package com.example.writerdemo.service.impl;

import com.example.writerdemo.entity.Report;
import com.example.writerdemo.mapper.ReportMapper;
import com.example.writerdemo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/01
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public Boolean save(Report report) {
        try {
            int rows = reportMapper.insertOrUpdate(report);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String queryContentByUsername(String username) {
        try {
            Report report = reportMapper.selectByUsername(username);
            return report.getContent();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
