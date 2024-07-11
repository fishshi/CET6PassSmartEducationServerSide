package com.smarteducationserverside.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smarteducationserverside.dao.ExamDao;
import com.smarteducationserverside.mapper.ExamMapper;
import com.smarteducationserverside.pojo.Answer;
import com.smarteducationserverside.pojo.Question;

@Repository
public class ExamDaoImpl implements ExamDao {
    @Autowired
    private ExamMapper examMapper;

    @Override
    public Question getQuestionById(int id) {
        return examMapper.getQuestionById(id);
    }

    @Override
    public Answer getAnswerById(int id) {
        return examMapper.getAnswerById(id);
    }

    @Override
    public int getCategoryById(int id) {
        return examMapper.getCategoryById(id);
    }
}
