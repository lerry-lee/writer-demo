package com.example.writerdemo.mapper;

import com.example.writerdemo.entity.Posts;
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
public interface PostsMapper {
    @Insert("INSERT into posts (author,sdate,category,dianzan,content,title,totalComments) " +
            "values (#{author},#{sdate},#{category},#{dianzan},#{content},#{title}," +
            "#{totalComments})")
    void insert(Posts posts);

    @Select("SELECT * from posts")
    List<Posts> selectAll();

    @Select("SELECT * from posts where author = #{author}")
    List<Posts> selectAllByAuthor(String author);

    @Select("SELECT * from posts where " +
            "(#{keyWords} is null or (title like #{keyWords} or content like #{keyWords})) " +
            "and (#{category} is null or category=#{category}) and (#{author} is null or author=#{author})")
    List<Posts> fuzzyQuery(String keyWords,String category,String author);

    @Update("UPDATE posts set totalComments=totalComments+1 where id = #{sid}")
    int updateCommentsByOne(Integer sid);
}
