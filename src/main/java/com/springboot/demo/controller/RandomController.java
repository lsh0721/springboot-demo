/*
 * Author:   lishihui
 * FileName: RandomController
 * Date:     2019/12/16 17:04
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.controller;

import com.springboot.demo.dmo.SampleProperty;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉
 * 〈随机值的controller〉
 *
 * @USER lishihui
 * @DATE 2019/12/16 17:04
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/random")
public class RandomController {

    @Value("${my.secret}")
    private String mySecret;

    @Value("${my.number}")
    private int myNumber;

    @Value("${my.bignumber}")
    private long myBignumber;

    @Value("${my.uuid}")
    private String myUuid;

    @Value("${my.less.than.ten}")
    private int myLessThanTen;

    @Value("${my.in.range}")
    private int myInRange;

    @Autowired
    private SampleProperty property;

    @RequestMapping("random.do")
    public String random() {
        StringBuffer result = new StringBuffer();
        result.append("mySecret:").append(mySecret).append(",");
        result.append("myNumber:").append(myNumber).append(",");
        result.append("myBignumber:").append(myBignumber).append(",");
        result.append("myUuid:").append(myUuid).append(",");
        result.append("myNumberLessThanTen:").append(myLessThanTen).append(",");
        result.append("myNumberInRange:").append(myInRange);
        return result.toString();
    }

    @RequestMapping("list.do")
    public String getList(){
        return  property.toString();
    }

}
