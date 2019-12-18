/*
 * Author:   lishihui
 * FileName: SampleProperty
 * Date:     2019/12/17 10:12
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.dmo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @USER lishihui
 * @DATE 2019/12/17 10:12
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@ConfigurationProperties(prefix = "prefix")
@Component
public class SampleProperty {

    @Value("${prefix.listProp[0]}")
    private String listProp1;

    @Value("${prefix.listProp[1]}")
    private String listProp2;

    private List<String> listProp;

    public String getListProp1() {
        return listProp1;
    }

    public void setListProp1(String listProp1) {
        this.listProp1 = listProp1;
    }

    public String getListProp2() {
        return listProp2;
    }

    public void setListProp2(String listProp2) {
        this.listProp2 = listProp2;
    }

    public List<String> getListProp() {
        return listProp;
    }

    public void setListProp(List<String> listProp) {
        this.listProp = listProp;
    }

    @Override
    public String toString() {
        return "SampleProperty{" +
                "listProp1='" + listProp1 + '\'' +
                ", listProp2='" + listProp2 + '\'' +
                ", listProp=" + listProp +
                '}';
    }
}
