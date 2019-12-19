/*
 * Author:   lishihui
 * FileName: LoginInterceptor
 * Date:     2019/12/19 19:21
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉
 * 〈拦截器 -获取原始的Request、Response和
 * 所有的controller及方法名，但无法获取方法的参数信息。〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/19 19:21
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 请求处理之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @return true:继续调用 false:返回，不执行调用
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("------------LoginInterceptor在请求处理之前调用------------");
        return true;
    }

    /**
     * 请求处理之后，视图渲染之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("------------LoginInterceptor在请求处理之后，视图渲染之前调用------------");
    }


    /**
     * 请求处理结束，视图渲染结束之后的调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("------------LoginInterceptor在请求处理结束，视图渲染结束之后的调用------------");
    }
}
