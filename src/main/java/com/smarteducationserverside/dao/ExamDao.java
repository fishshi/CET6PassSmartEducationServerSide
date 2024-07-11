package com.smarteducationserverside.dao;

import com.smarteducationserverside.pojo.Answer;
import com.smarteducationserverside.pojo.Question;

/**
 * 个人测试数据接口
 */
public interface ExamDao {
    /**
     * 根据id获取题目
     * 
     * @param id 题目id
     * @return 题目对象
     */
    public Question getQuestionById(int id);

    /**
     * 根据id获取答案
     * 
     * @param id 题目id
     * @return 答案对象
     */
    public Answer getAnswerById(int id);

    /**
     * 根据id获取题目类型
     * 
     * @param id 题目id
     * @return 题目类型
     */
    public int getCategoryById(int id);
}
