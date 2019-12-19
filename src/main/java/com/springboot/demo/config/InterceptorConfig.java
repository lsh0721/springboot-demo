/*
 * Author:   lishihui
 * FileName: InterceptorConfig
 * Date:     2019/12/19 19:28
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.config;

import com.springboot.demo.aop.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 〈一句话功能简述〉
 * 等同于 在spring-mvc.xml配置文件内添加<mvc:interceptor>标签配置拦截器。
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/19 19:28
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new LoginInterceptor())
//                .excludePathPatterns("*.do")
                .addPathPatterns("/city/*.json");
    }
}
