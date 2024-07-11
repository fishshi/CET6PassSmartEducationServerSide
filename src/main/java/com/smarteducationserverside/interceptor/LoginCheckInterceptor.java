package com.smarteducationserverside.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.smarteducationserverside.utils.JwtUtils;
import com.smarteducationserverside.utils.StatusUtils;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 登录检查拦截器
 */
@SuppressWarnings("null")
@Component // 交予IOC容器管理
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 预处理方法，在请求处理之前进行调用
     * 
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  处理器对象
     * @return true：继续执行；false：中断执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String jwt = request.getHeader("token");
        if (StringUtils.hasLength(jwt)) {
            try {
                Claims claims = JwtUtils.parseJwt(jwt);
                String username = (String) claims.get("username");
                String jwtInRedis = stringRedisTemplate.opsForValue().get(username);
                if (jwtInRedis == null || !jwtInRedis.equals(jwt))
                    throw new Exception();
            } catch (Exception e) {
                response.setStatus(StatusUtils.NOT_LOGIN);
                return false;
            }
            return true;
        }
        response.setStatus(StatusUtils.NOT_LOGIN);
        return false;
    }
}