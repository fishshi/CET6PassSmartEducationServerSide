package com.smarteducationserverside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 单条聊天信息数据
 */
@AllArgsConstructor
@Data
public class ChatData {
    private int id;
    private boolean isUser;
    private String text;
}