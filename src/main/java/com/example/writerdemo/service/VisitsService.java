package com.example.writerdemo.service;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface VisitsService {
    //添加一条访问记录
    Boolean add(String username, String vdate);

    //获取访问量总数
    Integer getCount();
}
