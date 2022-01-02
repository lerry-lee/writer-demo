package com.example.writerdemo.mapper;

import com.example.writerdemo.entity.Messages;
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
public interface MessagesMapper {
    @Insert("INSERT into messages (username,sid,message,comment,isRead) " +
            "values (#{username},#{sid},#{message},#{comment},#{isRead})")
    void insert(Messages messages);

    @Select("SELECT * from messages where username = #{username}")
    List<Messages> selectAll(String username);

    @Select("SELECT * from messages where username = #{username} " +
            "and isRead = 0")
    List<Messages> selectAllNotRead(String username);

    @Update("UPDATE messages set isRead = 1 where id = #{id}")
    int readMessage(int id);

    @Update("UPDATE messages set isRead = 1 where username = #{username}")
    int readAllMessageByUsername(String username);

    @Select("SELECT count(id) from messages where username = #{username} " +
            "and isRead = 0")
    int countNotRead(String username);
}
