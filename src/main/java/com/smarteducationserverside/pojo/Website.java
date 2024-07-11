package com.smarteducationserverside.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 实用网站链接实体类
 */
@AllArgsConstructor
@Data
public class Website {
    private String name;
    private String url;
    private String description;
    private String icon;
}