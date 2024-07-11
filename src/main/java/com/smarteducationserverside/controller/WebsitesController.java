package com.smarteducationserverside.controller;

import org.springframework.web.bind.annotation.RestController;

import com.smarteducationserverside.anno.Log;
import com.smarteducationserverside.pojo.Result;
import com.smarteducationserverside.service.WebsitesService;
import com.smarteducationserverside.utils.ResultUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 实用链接控制器
 */
@RestController
public class WebsitesController {
    @Autowired
    private WebsitesService wService;

    /**
     * 获取实用链接列表
     * 
     * @return 返回结果 {@Link Result}
     */
    @Log
    @RequestMapping("/websites")
    public Result getWebisteList() {
        return ResultUtils.success(wService.getAllWebsites());
    }
}