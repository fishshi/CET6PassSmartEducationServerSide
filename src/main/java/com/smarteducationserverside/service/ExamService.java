package com.smarteducationserverside.service;

import com.smarteducationserverside.pojo.Answer;
import com.smarteducationserverside.pojo.Question;

/**
 * 个人测试服务接口
 */
public interface ExamService {
    /**
     * 获取题目
     * 
     * @return 题目 {@link Question}
     */
    public Question getQuestion();

    /**
     * 提交答案
     * 
     * @param username   用户名
     * @param id         题目ID
     * @param userAnswer 用户答案
     * @return 答案 {@link Answer}
     */
    public Answer submitAnswer(String username, int id, char userAnswer);
}