/*
 * Author:   lishihui
 * FileName: User
 * Date:     2019/12/20 11:58
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.dmo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/20 11:58
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@ApiModel
@Data
public class User {

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户id", dataType = "Long")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名", dataType = "String")
    private String userName;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址", dataType = "String")
    private String address;
}
