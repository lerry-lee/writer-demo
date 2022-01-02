package com.example.writerdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Posts implements Serializable {
    private Integer id;
    private String author;
    private String sdate;
    private String category;
    private String content;
    private String title;
    private Integer dianzan;
    private Integer totalComments;
}
