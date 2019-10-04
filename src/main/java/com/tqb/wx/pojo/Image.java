package com.tqb.wx.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @ClassName Image
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/28 20:42
 * @Version v1.0
 */
@Data
public class Image {
    @XStreamAlias("MediaId")
    private String mediaId;
}
