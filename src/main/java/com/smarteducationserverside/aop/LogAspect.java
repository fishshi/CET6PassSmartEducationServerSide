package com.smarteducationserverside.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.smarteducationserverside.pojo.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * 日志切面类
 */
@Slf4j // 日志
@Component // IOC
@Aspect // 切面类
public class LogAspect {
    @Pointcut("@annotation(com.smarteducationserverside.anno.Log)") // 切入点表达式
    private void pt() {
    }

    /**
     * 控制器常规日志切面
     * 
     * @param point 切入点
     * @return 控制器方法返回值 {@link Result}
     * @throws Throwable 异常
     */
    @Around("pt()") // 通知类型Around,操作连接点前后
    public Object controllerNormalLog(ProceedingJoinPoint point) throws Throwable {
        log.info("" + System.currentTimeMillis());
        log.info(point.getTarget().getClass().getName());
        log.info(point.getSignature().getName());
        for (Object arg : point.getArgs())
            log.info(arg.toString());
        Result result;
        try {
            result = (Result) point.proceed();
            log.info(result.toString());
            return result;
        } catch (Throwable e) {
            log.info("exception");
            throw e;
        }
    }
}