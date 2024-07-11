package com.smarteducationserverside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 个人测试题答案实体类
 */
@AllArgsConstructor
@Data
public class Answer {
    private int id;
    private int category;
    private char answer;
    private String analysis;
}
