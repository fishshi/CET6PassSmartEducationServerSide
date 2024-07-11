package com.smarteducationserverside.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smarteducationserverside.pojo.Download;

/**
 * 六级试题下载Mapper接口
 */
@Mapper
public interface DownloadMapper {

    /**
     * 获取所有六级试题下载信息
     * 
     * @return 六级试题下载信息列表
     */
    @Select("SELECT fileName, fileUrl, coverUrl FROM tb_download order by date desc")
    public List<Download> getDownloadList();
}