package com.smarteducationserverside.controller;

import org.springframework.web.bind.annotation.RestController;

import com.smarteducationserverside.anno.Log;
import com.smarteducationserverside.pojo.Result;
import com.smarteducationserverside.pojo.UserAbility;
import com.smarteducationserverside.service.UserAbilityService;
import com.smarteducationserverside.utils.JwtUtils;
import com.smarteducationserverside.utils.ResultUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户能力控制器
 */
@RestController
@RequestMapping("/ability")
public class UserAbilityController {
    @Autowired
    private UserAbilityService uAbleService;

    /**
     * 获取用户能力
     * 
     * @param request 请求对象
     * @return msg:错误信息, data:用户能力 {@link Result}
     */
    @Log
    @RequestMapping("/get")
    public Result requestMethodName(@RequestHeader("token") String token) {
        String username = (String) JwtUtils.parseJwt(token).get("username");
        UserAbility userAbility = uAbleService.getUserAbility(username);
        if (userAbility == null)
            throw new RuntimeException("用户能力未找到");
        return ResultUtils.success(userAbility.toArrayList());
    }
}