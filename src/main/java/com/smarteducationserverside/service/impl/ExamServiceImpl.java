package com.smarteducationserverside.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarteducationserverside.dao.ExamDao;
import com.smarteducationserverside.dao.UserAbilityDao;
import com.smarteducationserverside.pojo.Answer;
import com.smarteducationserverside.pojo.Question;
import com.smarteducationserverside.pojo.UserAbility;
import com.smarteducationserverside.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;

    @Autowired
    private UserAbilityDao uAbilityDao;

    @Override
    public Question getQuestion() {
        return examDao.getQuestionById(new Random().nextInt(20) + 1);
    }

    @Override
    public Answer submitAnswer(String username, int id, char userAnswer) {
        Answer answer = examDao.getAnswerById(id);
        if (userAnswer == answer.getAnswer()) {
            UserAbility uAbility = uAbilityDao.getUserAbility(username);
            List<Byte> abilities = uAbility.toArrayList();
            byte ability = abilities.get(answer.getCategory() - 1) == (byte) 100 ? (byte) 100
                    : (byte) (abilities.get(answer.getCategory() - 1) + 1);
            abilities.set(answer.getCategory() - 1, ability);
            uAbility.setAbility(abilities);
            uAbilityDao.updateUserAbility(uAbility);
        }
        return answer;
    }
}
