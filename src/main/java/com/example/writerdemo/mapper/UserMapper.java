package com.example.writerdemo.mapper;

import com.example.writerdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User selectByUsername(String username);

    @Select("SELECT * FROM user WHERE username = #{username} and password = #{password}")
    User selectByUser(User user);

    @Insert("INSERT INTO user (username,password) VALUES (#{username},#{password})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id") //该注解用于返回主键
    void insert(User user);
}
