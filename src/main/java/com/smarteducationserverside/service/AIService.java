package com.smarteducationserverside.service;

import java.util.List;

import com.smarteducationserverside.pojo.ChatData;

/**
 * AI服务接口
 */
public interface AIService {
    /**
     * 向AI系统发送聊天数据，获取AI的回复
     * 
     * @param chatDataList 历史聊天记录数据列表 {@link ChatData}
     * @return AI的回复
     */
    public String getAnswer(List<ChatData> chatDataList);
}
