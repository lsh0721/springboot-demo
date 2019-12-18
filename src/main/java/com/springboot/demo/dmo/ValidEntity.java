/*
 * Author:   lishihui
 * FileName: ValidEntity
 * Date:     2019/12/17 20:38
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.dmo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 〈一句话功能简述〉
 * 〈校验实体类〉
 *
 * @USER lishihui
 * @DATE 2019/12/17 20:38
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Data
public class ValidEntity {

    @NotBlank(message = "name不可以为空")
    @Size(min = 2, max = 4, message = "name的长度范围为2-4")
    private String name;

    @NotNull(message = "height 不能为null")
    @Min(value = 0, message = "height 最小值不能小于0")
    private int height;
}
