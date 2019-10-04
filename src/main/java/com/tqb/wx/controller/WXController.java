package com.tqb.wx.controller;

import com.tqb.wx.pojo.AccessToken;
import com.tqb.wx.service.WXService;
import com.tqb.wx.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @ClassName WXController
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/26 21:16
 * @Version v1.0
 */
@RestController
@PropertySource(value = {"classpath:wx.properties"})
@Slf4j
public class WXController {

    @Value("${MY_TOKEN}")
    private String MY_TOKEN;

    @Autowired
    private WXService wxService;

    // 验证签名
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public String verify(String signature, String timestamp, String nonce, String echostr) {
        log.info("signature:" + signature + " timestamp:" + timestamp + " nonce:" + nonce + " echostr:" + echostr);
        // 1）将token、timestamp、nonce三个参数进行字典序排序
        String[] para = {MY_TOKEN, timestamp, nonce};
        Arrays.sort(para);
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str = para[0] + para[1] + para[2];
        String sha1 = sha1(str);
        // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        // 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容
        if (sha1.equalsIgnoreCase(signature)) {
            log.info("---------------------签名验证成功--------------------" + ":" + signature);
            return echostr;
        } else
            log.error("-----------------------签名验证失败----------------------" + signature + "---" + sha1);
        return null;
    }

    // 获取用户发来的消息
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public String receiveMsg(HttpServletRequest request) {
        ServletInputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
        } catch (IOException e) {
            log.error("-----------------获取输入流失败-------------------");
            e.printStackTrace();
        }
        // 将xml数据转换为map
        Map<String, String> map = XmlToMap(inputStream);
        // 对不同数据进行处理
        String xml = wxService.deal(map);
        return xml;
    }

    // 采用sha1加密
    private String sha1(String str) {
        String sha1Str = DigestUtils.sha1Hex(str);
        return sha1Str;
    }

    // 将用户发送的xml数据转换为Map
    public Map<String, String> XmlToMap(InputStream inputStream) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(inputStream);
        } catch (DocumentException e) {
            log.error("-------------------XML转换MAP失败--------------------");
            e.printStackTrace();
        }
        // 获取根结点
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        Map<String, String> map = new HashMap<>();
        for (Element element :
                elements) {
            map.put(element.getName(), element.getStringValue());
        }
        return map;
    }
}
