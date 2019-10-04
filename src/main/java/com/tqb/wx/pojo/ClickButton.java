package com.tqb.wx.pojo;

import lombok.Data;

/**
 * @ClassName ClickButton
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 12:43
 * @Version v1.0
 */
@Data
public class ClickButton extends AbstructButton{
    private String type = "click";
    private String key;

    public ClickButton(String name, String key) {
        super(name);
        this.key = key;
    }
}
