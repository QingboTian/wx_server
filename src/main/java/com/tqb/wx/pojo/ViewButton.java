package com.tqb.wx.pojo;

import lombok.Data;

/**
 * @ClassName ViewButton
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 15:27
 * @Version v1.0
 */
@Data
public class ViewButton extends AbstructButton{
    private String type="view";
    private String url;

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
    }
}
