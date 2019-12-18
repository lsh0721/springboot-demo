/*
 * Author:   lishihui
 * FileName: CityInfoServiceImpl
 * Date:     2019/12/17 17:51
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.service.impl;

import com.springboot.demo.Dao.CityInfoDao;
import com.springboot.demo.dmo.CityInfo;
import com.springboot.demo.service.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class CityInfoServiceImpl implements CityInfoService {

    @Autowired
    private CityInfoDao cityDao;

    @Override
    public List<CityInfo> getCityList() {
        return cityDao.getCityList();
    }

    @Override
    public CityInfo getCityById(Long id) {
        return cityDao.getCityById(id);
    }

    @Override
    public CityInfo getCityByName(String cityName) {
        return cityDao.getCityByName(cityName);
    }
}
