package com.tqb.wx.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName ImageMessage
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 12:33
 * @Version v1.0
 */
@Data
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage{
    @XStreamAlias("Image")
    private Image image = new Image();

    public ImageMessage(Map<String, String> map, String mediaId) {
        super(map);
        this.msgType = "image";
        this.image.setMediaId(mediaId);
    }
}
