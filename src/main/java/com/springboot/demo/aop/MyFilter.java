/*
 * Author:   lishihui
 * FileName: MyFilter
 * Date:     2019/12/19 17:41
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.aop;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 〈一句话功能简述〉
 * 〈过滤器 -只能获取到request和response的信息〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/19 17:41
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Slf4j
@WebFilter(urlPatterns = "*.htm", filterName = "MyFilter")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("-------------MyFilter.init-------------");
    }

    /**
     * 拦截请求 后处理逻辑
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("-------------过滤器拦截请求-------------");
        Long startTime = System.currentTimeMillis();
        log.info("-------------处理逻辑-------------");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("-------------过滤器处理结束，耗时:{}毫秒-------------", System.currentTimeMillis() - startTime);
    }

    @Override
    public void destroy() {
        log.info("-------------MyFilter.init-------------");
    }
}
