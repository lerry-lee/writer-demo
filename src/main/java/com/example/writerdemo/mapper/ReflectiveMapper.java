package com.example.writerdemo.mapper;

import com.example.writerdemo.entity.Reflective;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Mapper
public interface ReflectiveMapper {
    @Insert("INSERT into reflective (username,title,content,self,comparison," +
            "summary,automatic,sdate) values (#{username},#{title},#{content}," +
            "#{self},#{comparison},#{summary},#{automatic},#{sdate})")
    void insert(Reflective reflective);

    @Delete("DELETE from reflective where id = #{id}")
    int delete(Integer id);

    @Select("SELECT * from reflective where username = #{username} LIMIT #{limit} OFFSET #{offset}")
    List<Reflective> selectAllByUsernameWithLimit(String username, int limit, int offset);

    @Select("SELECT * from reflective where username = #{username}")
    List<Reflective> selectAllByUsername(String username);

    @Select("SELECT * from reflective where username = #{username} " +
            "and title like #{title} " +
            "and sdate between #{startDate} and #{endDate} " +
            "LIMIT #{limit} OFFSET #{offset}")
    List<Reflective> selectByTitleAndDate(String username, String title, String startDate, String endDate, int limit, int offset);

    @Select("select count(id) from reflective where username = #{username}")
    int getTotal(String username);

    @Select("select count(id) from reflective where username = #{username} " +
            "and title like #{title} " +
            "and sdate between #{startDate} and #{endDate}")
    int getTotalBySearch(String username, String title, String startDate, String endDate);
}
