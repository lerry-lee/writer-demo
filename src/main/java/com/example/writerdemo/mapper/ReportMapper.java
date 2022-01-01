package com.example.writerdemo.mapper;

import com.example.writerdemo.entity.Report;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Mapper
public interface ReportMapper {
    @Select("SELECT * from report where username = #{username}")
    Report selectByUsername(String username);

    @Insert("INSERT into report (username, content) values" +
            "(#{username},#{content}) ON DUPLICATE KEY UPDATE " +
            "content = values(content)")
    int insertOrUpdate(Report report);
}
