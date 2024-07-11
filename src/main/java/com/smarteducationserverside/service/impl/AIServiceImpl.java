package com.smarteducationserverside.service.impl;

import com.smarteducationserverside.pojo.ChatData;
import com.smarteducationserverside.service.AIService;
import com.smarteducationserverside.utils.SparkAIUtils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService {
    @Autowired
    private SparkAIUtils sparkAIUtils;

    @Override
    public String getAnswer(List<ChatData> chatDataList) {
        return sparkAIUtils.sendMesToAIUseXingHuo(chatDataList);
    }
}