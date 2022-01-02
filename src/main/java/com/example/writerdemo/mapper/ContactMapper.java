package com.example.writerdemo.mapper;

import com.example.writerdemo.entity.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Mapper
public interface ContactMapper {
    @Insert("INSERT into contact (username,name,email,comments) " +
            "values (#{username},#{name},#{email},#{comments})")
    void insert(Contact contact);
}
