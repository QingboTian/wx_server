package com.tqb.wx.service.impl;

import com.thoughtworks.xstream.XStream;
import com.tqb.wx.pojo.ImageMessage;
import com.tqb.wx.pojo.TextMessage;
import com.tqb.wx.service.WXService;
import com.tqb.wx.utils.MsgUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName WXServiceImpl
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/26 23:58
 * @Version v1.0
 */
@Service
@Slf4j
public class WXServiceImpl implements WXService {
    @Value("${XIYOU_MAP_ID}")
    private String XIYOU_MAP_ID;
    // 对消息进行处理
    @Override
    public String deal(Map<String, String> map) {
        System.out.println(map);
        // 获取消息类型
        String msgType = map.get("MsgType");
        if (MsgUtils.isText(msgType)) {
            String content = map.get("Content");
            String replyContent = "文本消息回复成功";
            log.info("-----------------发送来的消息为:" + content + "-------------------");
            log.info("-----------------回复的消息为:" + replyContent + "-------------------");
            TextMessage textMessage = new TextMessage(map, replyContent);
            XStream xstream = new XStream();
            xstream.processAnnotations(TextMessage.class);
            String xml = xstream.toXML(textMessage);
            log.info(xml);
            return xml;
        } else if (MsgUtils.isEvent(msgType)) {
            if (map.get("Event").equalsIgnoreCase("CLICK")){
                XStream xstream = new XStream();
                xstream.processAnnotations(TextMessage.class);
                TextMessage textMessage = null;
                if (map.get("EventKey").equalsIgnoreCase("11")){
                    textMessage = new TextMessage(map, "这可难不倒我哟！直接发送教室编号，我就告诉你怎么走，如：FZ209");
                }else if (map.get("EventKey").equalsIgnoreCase("12")){// 西邮地图
                    ImageMessage imageMessage = new ImageMessage(map,XIYOU_MAP_ID);
                    XStream xstream_img = new XStream();
                    xstream_img.processAnnotations(ImageMessage.class);
                    String xml = xstream_img.toXML(imageMessage);
                    log.info(xml);
                    return xml;
                } else if (map.get("EventKey").equalsIgnoreCase("13")){// 快速评教
                    textMessage = new TextMessage(map, "不要着急，该功能正在开发，马上上线哦！");
                } else if (map.get("EventKey").equalsIgnoreCase("14")){// 文字识别
                    // 调用百度AI接口

                    // 将识别信息进行返回
                    textMessage = new TextMessage(map, "识别信息");
                } else if (map.get("EventKey").equalsIgnoreCase("33")){
                    textMessage = new TextMessage(map, "本公众号可进行活动推广，有意者联系Email:tqb820965236@163.com");
                } else {
                    textMessage = new TextMessage(map, "点击");
                }
                String xml = xstream.toXML(textMessage);
                log.info(xml);
                return xml;
            }
        } else if (MsgUtils.isImage(msgType)) {

        } else  {
            XStream xstream = new XStream();
            xstream.processAnnotations(TextMessage.class);
            TextMessage textMessage = new TextMessage(map, "小的还不支持这种类型的消息，没有解决大人的问题，小的很伤心呢，呜呜呜...");
            String xml = xstream.toXML(textMessage);
            log.info(xml);
            return xml;
        }
        return null;
    }

}
