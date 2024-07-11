package com.smarteducationserverside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 后端自用用户信息（含密码）
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
}