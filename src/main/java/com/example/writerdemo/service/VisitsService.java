package com.example.writerdemo.service;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface VisitsService {
    boolean add(String username,String vdate);
    int getCount();
}
