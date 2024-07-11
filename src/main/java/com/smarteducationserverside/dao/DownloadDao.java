package com.smarteducationserverside.dao;

import com.smarteducationserverside.pojo.Download;
import java.util.List;

/**
 * 六级试题下载数据访问接口
 */
public interface DownloadDao {
    /**
     * 获取所有六级试题下载数据列表
     * 
     * @return 六级试题下载数据列表 {@link Download}
     */
    public List<Download> getDownloadList();
}
