package com.smarteducationserverside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 响应结果类
 */
@Data
@AllArgsConstructor // 生成全参构造方法
public class Result {
    private Integer code;// 响应码
    private String msg;// 提示信息
    private Object data;// 返回信息
}