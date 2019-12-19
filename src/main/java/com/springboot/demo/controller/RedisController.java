/*
 * Author:   lishihui
 * FileName: RedisController
 * Date:     2019/12/18 15:51
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.controller;

import com.springboot.demo.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉
 * 〈redis测试controller 〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/18 15:51
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    /**
     * 日志
     */
    private Logger LOGGER = LoggerFactory.getLogger(RedisController.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("set.do")
    public boolean set(String key, String value) {
        return RedisUtil.set(redisTemplate, key, value);
    }

    @RequestMapping("get.do")
    public Object get(String key) {
        return RedisUtil.get(redisTemplate, key);
    }
}
