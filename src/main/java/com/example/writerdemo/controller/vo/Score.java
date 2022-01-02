package com.example.writerdemo.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Score {
    private Integer id;
    private Integer self;
    private Integer comparison;
    private Integer summary;
    private Integer automatic;
}
