package com.smarteducationserverside.controller;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RestController;

import com.smarteducationserverside.anno.Log;
import com.smarteducationserverside.pojo.RespondUser;
import com.smarteducationserverside.pojo.Result;
import com.smarteducationserverside.service.UserService;
import com.smarteducationserverside.utils.JwtUtils;
import com.smarteducationserverside.utils.SHA256Utils;

import com.smarteducationserverside.utils.ResultUtils;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户信息控制器
 */
@RestController // 相当于@Controller（将当前控制器类类交给IOC容器管理） + @ResponseBody（将返回值作为响应体）
@RequestMapping("/user") // 定义请求路径
public class UserInfoController {
    @Autowired // 程序运行时，IOC容器提供该类型的bean对象（依赖注入）
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 注册
     * 
     * @param username 用户名
     * @param password 密码
     * @return 返回注册结果
     */
    @Log // 记录日志注解
    @RequestMapping("/register")
    public Result register(String username, String password) {
        if (username == null || password == null)
            return ResultUtils.error("注册失败,缺少参数");
        else {
            password = SHA256Utils.sha256(password);
            if (userService.register(username, password) == 1)
                return ResultUtils.success("注册成功");
            return ResultUtils.error("注册失败,用户名已存在");
        }
    }

    /**
     * 登录
     * 
     * @param username 用户名
     * @param password 密码
     * @return 返回登录结果
     */
    @Log
    @RequestMapping("/login")
    public Result login(String username, String password) {
        if (username == null || password == null)
            return ResultUtils.error("登录失败,缺少参数");
        else {
            password = SHA256Utils.sha256(password);
            if (userService.login(username, password) == 1) {
                String token = JwtUtils.generateJwt(new HashMap<String, Object>() {
                    {
                        put("username", username);
                    }
                });
                // 把token存储到redis中
                ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
                operations.set(username, token, 24, TimeUnit.HOURS);
                return ResultUtils.success(token);
            } else
                return ResultUtils.error("用户名或密码错误");
        }
    }

    /**
     * 前端获取用户信息
     * 
     * @param request 请求对象
     * @return 返回可返回至前端的用户信息（不带密码）
     */
    @Log
    @RequestMapping("/getuser")
    public Result getUser(@RequestHeader("token") String token) {
        String username = (String) JwtUtils.parseJwt(token).get("username");
        return ResultUtils.success(userService.getUser(username));
    }

    /**
     * 修改密码
     * 
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param request     请求对象
     * @return 返回修改结果
     */
    @Log
    @RequestMapping("/updatepassword")
    public Result updataPassword(String oldPassword, String newPassword, @RequestHeader("token") String token) {
        String username = (String) JwtUtils.parseJwt(token).get("username");
        oldPassword = SHA256Utils.sha256(oldPassword);
        newPassword = SHA256Utils.sha256(newPassword);
        if (userService.updatePassword(username, oldPassword, newPassword) == 1) {
            stringRedisTemplate.delete(username);
            return ResultUtils.success("修改成功");
        } else
            return ResultUtils.error("修改失败,旧密码错误");
    }

    /**
     * 修改用户信息
     * 
     * @param user    用户信息
     * @param request 请求对象
     * @return 返回修改结果
     */
    @Log
    @RequestMapping("/updateuserinfo")
    public Result updateUserInfo(@RequestBody RespondUser user, @RequestHeader("token") String token) {
        String username = (String) JwtUtils.parseJwt(token).get("username");
        if (userService.updateUserInfo(user, username) == 1)
            return ResultUtils.success("修改成功");
        else
            return ResultUtils.error("修改失败,用户信息异常");
    }

    /**
     * 修改头像
     * 
     * @param avatarUrl 头像地址
     * @param request   请求对象
     * @return 返回修改结果
     */
    @Log
    @RequestMapping("/updateavatar")
    public Result requestMethodName(String avatarUrl, @RequestHeader("token") String token) {
        String username = (String) JwtUtils.parseJwt(token).get("username");
        if (userService.updateAvatarUrl(avatarUrl, username) == 1) {
            return ResultUtils.success("修改成功");
        } else {
            return ResultUtils.error("修改失败,用户信息异常");
        }
    }
}