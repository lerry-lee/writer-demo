package com.example.writerdemo.service.impl;

import com.example.writerdemo.entity.Visits;
import com.example.writerdemo.mapper.VisitsMapper;
import com.example.writerdemo.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/01
 */
@Service
public class VisitsServiceImpl implements VisitsService {

    @Autowired
    private VisitsMapper visitsMapper;

    @Override
    public boolean add(String username, String vdate) {
        String sign = username + vdate;
        Visits visits = Visits.builder().sign(sign).build();
        visitsMapper.insert(visits);
        return visits.getId() != null;
    }

    @Override
    public int getCount() {
        return visitsMapper.count();
    }
}
