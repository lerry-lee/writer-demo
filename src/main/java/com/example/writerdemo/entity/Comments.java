package com.example.writerdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comments {
    private Integer id;
    private Integer sid;
    private String comment;
    private String cdate;
    private String commentator;
}
