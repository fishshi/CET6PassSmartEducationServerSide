package com.smarteducationserverside.controller;

import com.smarteducationserverside.service.AIService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.smarteducationserverside.anno.Log;
import com.smarteducationserverside.pojo.Result;
import com.smarteducationserverside.pojo.ChatData;
import com.smarteducationserverside.utils.ResultUtils;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AI控制器
 */
@RequestMapping("/ai")
@RestController
public class AIController {
    @Autowired
    private AIService aiService;

    /**
     * 与AI对话
     * 
     * @param chatDataList 对话历史记录信息列表
     * @return AI回复结果
     */
    @Log
    @RequestMapping("/chat")
    public Result chat(@RequestBody List<ChatData> chatDataList) {
        return ResultUtils.success(aiService.getAnswer(chatDataList));
    }
}