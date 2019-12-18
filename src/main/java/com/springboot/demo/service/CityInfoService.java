/*
 * Author:   lishihui
 * FileName: CityInfoService
 * Date:     2019/12/17 17:51
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.service;

import com.springboot.demo.dmo.CityInfo;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER lishihui
 * @DATE 2019/12/17 17:51
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public interface CityInfoService {

    /**
     * 查询所有城市列表
     *
     * @return
     */
    List<CityInfo> getCityList();

    /**
     * 根据ID查询城市信息
     *
     * @param id
     * @return
     */
    CityInfo getCityById(Long id);

    /**
     * 根据名称查询城市信息
     *
     * @param cityName
     * @return
     */
    CityInfo getCityByName(String cityName);
}
