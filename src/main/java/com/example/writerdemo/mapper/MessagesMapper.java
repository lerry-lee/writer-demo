package com.example.writerdemo.mapper;

import com.example.writerdemo.entity.Messages;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Mapper
public interface MessagesMapper {
    int insert();

    List<Messages> select();

}
