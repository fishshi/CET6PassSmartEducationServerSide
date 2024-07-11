package com.smarteducationserverside.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smarteducationserverside.pojo.Website;

/**
 * 实用链接Mapper接口
 */
@Mapper
public interface WebsitesMapper {
    /**
     * 获取全部实用链接
     * 
     * @return {@Link Website}
     */
    @Select("SELECT * FROM tb_website")
    public List<Website> getAllWebsites();
}
