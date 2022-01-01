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
public class Reflective implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private Integer self;
    private Integer comparison;
    private Integer summary;
    private Integer automatic;
    private String sdate;
}
