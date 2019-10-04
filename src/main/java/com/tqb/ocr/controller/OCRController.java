package com.tqb.ocr.controller;

import com.baidu.aip.ocr.AipOcr;
import com.tqb.wx.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @ClassName OCRController
 * @Description: 文字识别控制层
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/29 11:27
 * @Version v1.0
 */
@RestController
@Slf4j
@PropertySource(value = {"classpath:baiduai.properties"})
@RequestMapping("/ocr/")
public class OCRController {

    @Value("${ACCESS_TOKEN_URL}")
    private String ACCESS_TOKEN_URL;

    @Value("${CLIENT_ID}")
    private String CLIENT_ID;

    @Value("${CLIENT_SECRET}")
    private String CLIENT_SECRET;

    @Value("${OCR_URL}")
    private String OCR_URL;

    @Value("${ACCESS_TOKEN")
    private String ACCESS_TOKEN;

    @Value("${APP_ID}")
    private String APP_ID;

    public String getAccessToken() {
        String url = ACCESS_TOKEN_URL.replace("CLIENT_ID", CLIENT_ID).replace("CLIENT_SECRET", CLIENT_SECRET);
        String response = "";
        String access_token = "";
        try {
            response = HttpClientUtils.get(url);
            log.info(response);
            JSONObject jsonObject = JSONObject.fromObject(response);
            access_token = jsonObject.getString("access_token");
        } catch (IOException e) {
            log.error("----------------获取百度AI TOKEN错误---------------");
            log.error(response);
            e.printStackTrace();
        }
        return access_token;
    }

    @RequestMapping("image")
    public String upload(MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String image = file.getOriginalFilename();
        try {
            // 将上传的图片保存到本地
            FileOutputStream outputStream = new FileOutputStream(image);
            InputStream inputStream = file.getInputStream();
            byte[] by = new byte[1024];
            int len = 0;
            while ((len = (inputStream.read(by))) != -1) {
                outputStream.write(by);
                outputStream.flush();
            }

            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            log.error("文件上传失败");
        }
        org.json.JSONObject res = null;
        try {
            AipOcr client = new AipOcr(APP_ID, CLIENT_ID, CLIENT_SECRET);

            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);

            HashMap<String, String> options = new HashMap<String, String>();
            options.put("language_type", "CHN_ENG");
            options.put("detect_direction", "true");
            options.put("detect_language", "true");
            options.put("probability", "true");
            res = client.basicGeneral(image, options);
            // System.out.println(res.toString(2));
        } catch (Exception e) {
            log.error("照片处理失败");
        }

        return res.toString();
    }
}