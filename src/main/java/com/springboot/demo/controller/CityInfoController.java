/*
 * Author:   lishihui
 * FileName: CityInfoController
 * Date:     2019/12/17 17:54
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.controller;

import com.springboot.demo.dmo.CityInfo;
import com.springboot.demo.service.CityInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/17 17:54
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/city")
@Slf4j
@Api(tags = "城市服务接口")
public class CityInfoController {

    @Autowired
    private CityInfoService cityInfoService;

    @RequestMapping("/cityList.do")
    public List<CityInfo> getCityList() {
        List<CityInfo> cityInfoList = cityInfoService.getCityList();
        log.info("查询城市列表:{}", cityInfoList);
        return cityInfoList;
    }

    @RequestMapping("/getCityById.do")
    public CityInfo getCityById(String id) {
        return cityInfoService.getCityById(Long.parseLong(id));
    }

    @RequestMapping("/getCityById.htm")
    public CityInfo getCityByIdForHtm(String id) {
        return cityInfoService.getCityById(Long.parseLong(id));
    }

    @RequestMapping("/getCityById.json")
    public CityInfo getCityByIdForJson(String id) {
        return cityInfoService.getCityById(Long.parseLong(id));
    }

    @RequestMapping("/getCityByName.do")
    public CityInfo getCityByName(String name) {
        return cityInfoService.getCityByName(name);
    }
}
