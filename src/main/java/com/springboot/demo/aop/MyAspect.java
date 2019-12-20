/*
 * Author:   lishihui
 * FileName: MyAspect
 * Date:     2019/12/20 9:37
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉
 * 拦截到具体controller 对应的方法的具体参数值
 * 但是拦截 不到 原始的request 和 response
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/20 9:37
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Slf4j
@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.springboot.*.controller..*.*(..))")
    public Object method(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("-------------Aspect处理-------------");
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            log.info("参数为:" + arg);
        }
        long start = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        log.info("-------------Aspect 耗时:{}毫秒-------------", (System.currentTimeMillis() - start));
        return object;
    }
}
