/*
 * Author:   lishihui
 * FileName: ValidationController
 * Date:     2019/12/17 20:42
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.controller;

import com.springboot.demo.dmo.ValidEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 〈一句话功能简述〉
 * 〈参数验证controller〉
 *
 * @USER lishihui
 * @DATE 2019/12/17 20:42
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/valid")
public class ValidationController {

    private Logger LOGGER = LoggerFactory.getLogger(ValidationController.class);

    @RequestMapping("valid.do")
    public String valid(@Valid ValidEntity validEntity) {
        LOGGER.info("-------请求参数-------:{}", validEntity);
        LOGGER.info("使用lombok插件实现get/set方法:{}",validEntity.getName());
        return "OK";
    }

}
