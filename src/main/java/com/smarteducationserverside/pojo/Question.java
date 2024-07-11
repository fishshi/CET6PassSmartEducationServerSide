package com.smarteducationserverside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 个人测试题问题实体类
 */
@AllArgsConstructor
@Data
public class Question {
    private int id;
    private String article;
    private String title;
    private String options;
}