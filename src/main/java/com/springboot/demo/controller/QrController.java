/*
 * Author:   lishihui
 * FileName: QrController
 * Date:     2019/12/30 19:53
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.controller;

import com.springboot.demo.util.QRCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/30 19:53
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Controller
@Slf4j
public class QrController {

    /**
     * 根据内容获取二维码图片
     *
     * @param response
     * @param content  二维码内容
     */
    @GetMapping("/getGrCode.do")
    public void getGrCode(HttpServletResponse response, String content) {
        try {
            log.info("生成二维码,content:{}", content);
            ImageIO.write(QRCodeUtil.generateGrCodeForBuffered(content), "png", response.getOutputStream());
        } catch (IOException e) {
            log.info("输出二维码到页面异常:{}", e);
        }

    }

}
