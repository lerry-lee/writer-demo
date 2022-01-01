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
public class Contact {
    private Integer id;
    private String username;
    private String name;
    private String email;
    private String comments;
}
