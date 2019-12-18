/*
 * Author:   lishihui
 * FileName: CityInfo
 * Date:     2019/12/17 17:06
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.dmo;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈城市信息〉
 *
 * @USER lishihui
 * @DATE 2019/12/17 17:06
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
public class CityInfo implements Serializable {

    private static final long serialVersionUID = -4022664475527850531L;

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 位置
     */
    private String state;

    /**
     * 国家
     */
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
