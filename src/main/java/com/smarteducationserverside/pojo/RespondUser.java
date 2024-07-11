package com.smarteducationserverside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回给前端的用户信息（不含密码）
 */
@Data
@AllArgsConstructor
public class RespondUser {
    private int id;
    private String username;
    private String email;
    private String avatarUrl;
}