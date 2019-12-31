/*
 * Author:   lishihui
 * FileName: QRCodeUtil
 * Date:     2019/12/31 11:17
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.util;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 〈一句话功能简述〉
 * 〈生成二维码工具类〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/31 11:17
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@Slf4j
public class QRCodeUtil {

    //二维码颜色
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;
    private static int width = 300;
    private static int height = 300;

    // 用于设置QR二维码参数
    private static Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
        private static final long serialVersionUID = 1L;

        {
            // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            // 设置编码方式
            put(EncodeHintType.CHARACTER_SET, "utf-8");
        }
    };

    public static void main(String[] args) throws Exception {
        File logoFile = new File("F:\\logo_weixin.png");
        zxingCodeCreate("http://www.suning.com", "D:/qrcode.png", "png", logoFile);
        //    zxingCodeAnalyze("D:/qrcode.jpg");
    }

    /**
     * 生成二维码
     *
     * @param text
     * @param outPutPath
     * @param imageType
     */
    public static void zxingCodeCreate(String text, String outPutPath, String imageType, File logoFile) {
        try {
            //1、生成二维码
            BitMatrix encode = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            //3、将二维码放入缓冲流
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    //4、循环将二维码内容定入图片  
                    image.setRGB(i, j, encode.get(i, j) ? BLACK : WHITE);
                }
            }
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            //5、绘制logo图片
            if (Objects.nonNull(logoFile) && logoFile.exists()) {
                // 构建绘图对象
                Graphics2D g = image.createGraphics();
                // 读取Logo图片
                BufferedImage logo = ImageIO.read(logoFile);
                // 开始绘制logo图片
                g.drawImage(logo, imageWidth * 2 / 5, imageHeight * 2 / 5, imageWidth * 2 / 10, imageHeight * 2 / 10, null);
                g.dispose();
                logo.flush();
            }

            File outPutImage = new File(outPutPath);
            //如果图片不存在创建图片  
            if (!outPutImage.exists()) {
                outPutImage.createNewFile();
            }
            //6、将二维码写入图片  
            image.flush();
            ImageIO.write(image, imageType, outPutImage);
        } catch (Exception e) {
            log.info("二维码生成失败:{}", e);
        }
        log.info("二维码生成完毕");
    }


    /**
     * 解析二维码
     *
     * @param analyzePath
     * @return
     * @throws Exception
     */
    public static String zxingCodeAnalyze(String analyzePath) throws Exception {
        return "";
    }
}