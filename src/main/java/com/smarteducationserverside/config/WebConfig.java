package com.smarteducationserverside.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.smarteducationserverside.interceptor.LoginCheckInterceptor;

/**
 * Web配置类
 */
@SuppressWarnings("null")
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    /**
     * 添加拦截器
     * 
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/user/register", "/ai/chat");
    }

    /**
     * 添加跨域配置
     * 
     * @param registry 跨域注册器
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有请求映射
                .allowedOrigins("http://localhost:5173") // 允许5173跨域请求
                .allowedHeaders("*") // 设置请求头
                .allowedMethods("*") // 允许所有请求方式
                .maxAge(3600); // 设置有效时间
    }
}