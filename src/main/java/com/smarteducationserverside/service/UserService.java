package com.smarteducationserverside.service;

import com.smarteducationserverside.pojo.RespondUser;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 登录
     * 
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回1，失败返回0
     */
    public int login(String username, String password);

    /**
     * 注册
     * 
     * @param username 用户名
     * @param password 密码
     * @return 注册成功返回1，失败返回0
     */
    public int register(String username, String password);

    /**
     * 获取用户信息（不带密码）
     * 
     * @param username 用户名
     * @return 用户信息 {@link RespondUser}
     */
    public RespondUser getUser(String username);

    /**
     * 更新密码
     * 
     * @param username    用户名
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 成功返回1，失败返回0
     */
    public int updatePassword(String username, String oldPassword, String newPassword);

    /**
     * 更新用户信息
     * 
     * @param user     用户信息 {@link RespondUser}
     * @param username 用户名
     * @return 成功返回1，失败返回0
     */
    public int updateUserInfo(RespondUser user, String username);

    /**
     * 更新头像
     * 
     * @param avatarUrl 头像URL
     * @param username  用户名
     * @return 成功返回1，失败返回0
     */
    public int updateAvatarUrl(String avatarUrl, String username);
}
