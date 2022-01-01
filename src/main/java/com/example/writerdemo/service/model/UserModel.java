package com.example.writerdemo.service.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/01
 * 用户模型，存放在Redis中，用于同步用户状态
 */
@Data
public class UserModel implements Serializable {
    private Integer id;
    private String username;
}
