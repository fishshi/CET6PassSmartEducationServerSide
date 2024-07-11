package com.smarteducationserverside.service;

import java.util.List;

import com.smarteducationserverside.pojo.Website;

/**
 * 实用网站链接服务接口
 */
public interface WebsitesService {
    /**
     * 获取所有实用网站链接
     * 
     * @return 实用网站链接列表 {@link Website}
     */
    public List<Website> getAllWebsites();
}
