package com.smarteducationserverside.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smarteducationserverside.pojo.Answer;
import com.smarteducationserverside.pojo.Question;

/**
 * 个人测试Mapper接口
 */
@Mapper
public interface ExamMapper {
    /**
     * 根据id获取题目信息
     * 
     * @param id 题目id
     * @return 题目信息 {@link Question}
     */
    @Select("SELECT id, article, title, options FROM tb_exam WHERE id = #{id}")
    public Question getQuestionById(int id);

    /**
     * 根据id获取答案信息
     * 
     * @param id 题目id
     * @return 答案信息 {@link Answer}
     */
    @Select("SELECT id, category, answer, analysis FROM tb_exam WHERE id = #{id}")
    public Answer getAnswerById(int id);

    /**
     * 根据id获取题目分类
     * 
     * @param id 题目id
     * @return 题目分类
     */
    @Select("SELECT category FROM tb_exam WHERE id = #{id}")
    public int getCategoryById(int id);
}