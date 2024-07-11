package com.smarteducationserverside.service;

/**
 * 文件上传服务接口
 */
public interface FileUploadService {
    /**
     * 头像文件上传
     * 
     * @param username 用户名
     * @return 上传成功返回图片路径，上传失败返回null
     */
    public String uploadAvatar(String username);
}
