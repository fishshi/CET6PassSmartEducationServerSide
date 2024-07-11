package com.smarteducationserverside.service;

import com.smarteducationserverside.pojo.UserAbility;

/**
 * 用户能力服务接口
 */
public interface UserAbilityService {
    /**
     * 根据用户名获取用户能力
     * 
     * @param username 用户名
     * @return 用户能力对象
     */
    public UserAbility getUserAbility(String username);
}