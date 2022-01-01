package com.example.writerdemo.mapper;

import com.example.writerdemo.entity.Visits;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Mapper
public interface VisitsMapper {
    @Insert("INSERT INTO visits (sign) VALUES (#{sign})")
    void insert(Visits visits);

    @Select("SELECT COUNT(id) FROM visits")
    int count();
}
