package com.example.writerdemo.mapper;

import com.example.writerdemo.entity.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Mapper
public interface CommentsMapper {

    @Insert("INSERT into comments (sid,comment,cdate,commentator) " +
            "values (#{sid},#{comment},#{cdate},#{commentator})")
    void insert(Comments comments);

    @Select("SELECT * from comments where sid = #{sid}")
    List<Comments> selectBySid(Integer sid);
}
