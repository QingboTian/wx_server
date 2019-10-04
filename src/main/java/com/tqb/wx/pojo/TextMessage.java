package com.tqb.wx.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName TextMessage
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 9:21
 * @Version v1.0
 */
@Data
@XStreamAlias("xml")
public class TextMessage extends BaseMessage{
    @XStreamAlias("Content")
    private String content;

    public TextMessage(Map<String, String> map, String content){
        super(map);
        this.content =content;
        this.msgType = "text";
    }
}
