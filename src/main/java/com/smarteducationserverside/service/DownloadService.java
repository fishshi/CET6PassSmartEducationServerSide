package com.smarteducationserverside.service;
import com.smarteducationserverside.pojo.Download;
import java.util.List;

/**
 * 下载服务接口
 */
public interface DownloadService {
    /**
     * 获取六级试题的下载列表
     * 
     * @return 六级试题的下载列表 {@link Download}
     */
    public List<Download> getDownloadList();
}
