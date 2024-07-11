package com.smarteducationserverside.dao;

import com.smarteducationserverside.pojo.UserAbility;

/**
 * 用户能力数据访问接口
 */
public interface UserAbilityDao {
    /**
     * 创建用户能力
     * 
     * @param userAbility 用户能力对象 {@link UserAbility}
     */
    public void createUserAbility(UserAbility userAbility);

    /**
     * 获取用户能力
     * 
     * @param username 用户名
     * @return 用户能力对象 {@link UserAbility}
     */
    public UserAbility getUserAbility(String username);

    /**
     * 更新用户能力
     * 
     * @param userAbility 用户能力对象 {@link UserAbility}
     */
    public void updateUserAbility(UserAbility userAbility);
}
