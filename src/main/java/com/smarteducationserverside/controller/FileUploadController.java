package com.smarteducationserverside.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smarteducationserverside.anno.Log;
import com.smarteducationserverside.pojo.Result;
import com.smarteducationserverside.service.FileUploadService;
import com.smarteducationserverside.utils.JwtUtils;
import com.smarteducationserverside.utils.ResultUtils;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件上传控制器
 */
@RestController
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 头像文件上传
     * 
     * @param file    头像文件
     * @param request 请求
     * @return 返回结果 data: 头像上传后的url
     * @throws IOException 异常
     */
    @Log
    @RequestMapping("/uploadavatar")
    public Result uploadAvatar(MultipartFile file, @RequestHeader("token") String token) {
        String username = (String) JwtUtils.parseJwt(token).get("username");
        try {
            file.transferTo(new File("D:\\" + username + ".jpg"));
        } catch (IOException e) {
            return ResultUtils.error("选中失败,请稍后重试或联系系统管理员");
        }
        String url = fileUploadService.uploadAvatar(username);
        if (url != null)
            return ResultUtils.success(url);
        else
            return ResultUtils.error("选中失败,请稍后重试或联系系统管理员");
    }

}
