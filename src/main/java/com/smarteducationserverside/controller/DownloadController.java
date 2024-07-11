package com.smarteducationserverside.controller;

import org.springframework.web.bind.annotation.RestController;

import com.smarteducationserverside.pojo.Result;
import com.smarteducationserverside.service.DownloadService;
import com.smarteducationserverside.utils.ResultUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smarteducationserverside.anno.Log;
import com.smarteducationserverside.pojo.Download;
import java.util.List;

/**
 * 下载控制器
 */
@RestController
public class DownloadController {
    @Autowired
    private DownloadService downloadService;

    /**
     * 获取六级试题下载信息列表
     * 
     * @return 六级试题下载信息列表
     */
    @Log
    @RequestMapping("/downloadlist")
    public Result getDownloadList() {
        List<Download> downloadList = downloadService.getDownloadList();
        if (downloadList != null)
            return ResultUtils.success(downloadList);
        else
            return ResultUtils.error("资源错误");
    }

}
