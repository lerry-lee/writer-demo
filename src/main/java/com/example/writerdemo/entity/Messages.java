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
public class Messages {
    private Integer id;
    private int sid;
    private String message;
    private String comment;
    private int isRead;
}
