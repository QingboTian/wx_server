package com.tqb.wx.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName BaseMessage
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 8:59
 * @Version v1.0
 */
@Data
public class BaseMessage {
    @XStreamAlias("ToUserName")
    protected String toUserName;
    @XStreamAlias("FromUserName")
    protected String fromUserName;
    @XStreamAlias("CreateTime")
    protected String createTime;
    @XStreamAlias("MsgType")
    protected String msgType;
    /*@XStreamAlias("MsgId")
    private String msgId;*/

    public BaseMessage() {
    }

    public BaseMessage(Map<String, String> map) {
        this.fromUserName = map.get("ToUserName");
        this.toUserName = map.get("FromUserName");
        this.createTime = System.currentTimeMillis() / 1000 + "";
        // this.msgType = map.get("MsgType");
        // this.msgId = map.get("MsgId");
    }
}