package com.example.writerdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/12/30
 * 访问统计表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visits {
    private Integer id;
    /**
     * 访问标记（由【用户id+时间戳】组成）每天每个用户只会被记录一次
     */
    private String sign;
}
