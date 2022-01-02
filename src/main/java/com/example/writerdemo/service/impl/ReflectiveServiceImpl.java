package com.example.writerdemo.service.impl;

import com.example.writerdemo.entity.Reflective;
import com.example.writerdemo.mapper.ReflectiveMapper;
import com.example.writerdemo.service.ReflectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@Service
public class ReflectiveServiceImpl implements ReflectiveService {

    @Autowired
    private ReflectiveMapper reflectiveMapper;

    @Override
    public Boolean add(Reflective reflective) {
        try {
            reflectiveMapper.insert(reflective);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Reflective> queryAllByUsername(String username, int limit, int offset) {
        try {
            List<Reflective> reflectives = reflectiveMapper.selectAllByUsernameWithLimit(username, limit, offset);
            return reflectives;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reflective> queryAllByUsername(String username) {
        try {
            List<Reflective> reflectives = reflectiveMapper.selectAllByUsername(username);
            return reflectives;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reflective> fuzzyQueryAllByUsername(String username, String title, String startDate, String endDate, int limit, int offset) {
        try {
            List<Reflective> reflectives = reflectiveMapper.selectByTitleAndDate(username, "%"+title+"%", startDate, endDate, limit, offset);
            return reflectives;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            int row = reflectiveMapper.delete(id);
            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer getTotal(String username) {
        try {
            int total = reflectiveMapper.getTotal(username);
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer getTotalBySearch(String username, String title, String startDate, String endDate) {
        try {
            int total = reflectiveMapper.getTotalBySearch(username, "%"+title+"%", startDate, endDate);
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
