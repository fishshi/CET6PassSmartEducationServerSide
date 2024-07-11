package com.smarteducationserverside.controller;

import org.springframework.web.bind.annotation.RestController;

import com.smarteducationserverside.anno.Log;
import com.smarteducationserverside.pojo.Result;
import com.smarteducationserverside.service.ExamService;
import com.smarteducationserverside.utils.JwtUtils;
import com.smarteducationserverside.utils.ResultUtils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 个人测试控制器
 */
@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    /**
     * 获取测试题目
     * 
     * @param uAbility 用户能力list
     * @return 测试题目 {@link Result}
     */
    @Log
    @RequestMapping("/question")
    public Result getQuestion(@RequestBody List<Integer> uAbilityList) {
        return ResultUtils.success(examService.getQuestion());
    }

    /**
     * 提交测试题答案并获取正确答案和解析
     * 
     * @param id         测试题目ID
     * @param userAnswer 用户答案
     * @param request    HTTP请求
     * @return 正确答案和解析 {@link Result}
     */
    @Log
    @RequestMapping("/answer")
    public Result getAnswer(int id, char userAnswer, @RequestHeader("token") String token) {
        String username = (String) JwtUtils.parseJwt(token).get("username");
        return ResultUtils.success(examService.submitAnswer(username, id, userAnswer));
    }

}