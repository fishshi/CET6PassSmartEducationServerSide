package com.smarteducationserverside.dao;

import com.smarteducationserverside.pojo.RespondUser;
import com.smarteducationserverside.pojo.User;

/**
 * 用户数据访问接口
 */
public interface UserDao {
    /**
     * 创建用户
     * 
     * @param user 用户对象 {@link User}
     */
    public void createUser(User user);

    /**
     * 根据用户名获取后端自用用户信息（带密码）
     * 
     * @param username 用户名
     * @return 用户对象 {@link User}
     */
    public User getUserByUsername(String username);

    /**
     * 根据用户名获取可返回至前端的用户信息（不带密码）
     * 
     * @param username 用户名
     * @return 用户对象 {@link RespondUser}
     */
    public RespondUser RespondUserByUsername(String username);

    /**
     * 根据用户名更新密码
     * 
     * @param username    用户名
     * @param newPassword 新密码
     */
    public void updatePassword(String username, String newPassword);

    /**
     * 更新用户信息
     * 
     * @param user 用户对象 {@link RespondUser}
     */
    public void updateUserInfo(RespondUser user);

    /**
     * 更新头像URL
     * 
     * @param user 用户对象 {@link RespondUser}
     */
    public void updateAvatarUrl(RespondUser user);
}
