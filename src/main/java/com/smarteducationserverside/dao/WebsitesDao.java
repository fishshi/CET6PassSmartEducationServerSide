package com.smarteducationserverside.dao;

import com.smarteducationserverside.pojo.Website;
import java.util.List;

/**
 * 实用网站链接数据访问接口
 */
public interface WebsitesDao {
    /**
     * 获取所有实用网站链接
     * 
     * @return 实用网站链接列表 {@link Website}
     */
    public List<Website> getAllWebsites();
}
