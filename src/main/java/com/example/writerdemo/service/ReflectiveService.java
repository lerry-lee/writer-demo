package com.example.writerdemo.service;

import com.example.writerdemo.entity.Reflective;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
public interface ReflectiveService {
    //添加一条记录
    Boolean add(Reflective reflective);

    //查找某个用户的所有记录
    List<Reflective> queryAllByUsername(String username, int offset, int row);

    //查找某个用户的所有记录
    List<Reflective> queryAllByUsername(String username);

    //模糊查找某个用户的所有记录
    List<Reflective> fuzzyQueryAllByUsername(String username, String title, String startDate, String endDate, int offset, int row);

    //删除一条记录
    Boolean delete(Integer id);

    //获取数据总数
    Integer getTotal(String username);

    //获取数据总数，根据模糊条件
    Integer getTotalBySearch(String username, String title, String startDate, String endDate);
}
