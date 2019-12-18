/*
 * Author:   lishihui
 * FileName: CityInfoDaoImpl
 * Date:     2019/12/17 17:25
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.Dao.impl;

import com.springboot.demo.Dao.CityInfoDao;
import com.springboot.demo.dmo.CityInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER lishihui
 * @DATE 2019/12/17 17:25
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Component
public class CityInfoDaoImpl implements CityInfoDao {

    @Autowired
    public SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<CityInfo> getCityList() {
        return sqlSessionTemplate.selectList("getCityList");
    }

    @Override
    public CityInfo getCityById(Long id) {
        return sqlSessionTemplate.selectOne("getCityById", id);
    }

    @Override
    public CityInfo getCityByName(String name) {
        return sqlSessionTemplate.selectOne("getCityByName", name);
    }
}
