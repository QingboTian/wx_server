package com.tqb.wx.pojo;

import lombok.Data;

/**
 * @ClassName AbstructButton
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 12:36
 * @Version v1.0
 */
@Data
public class AbstructButton {
    protected String name;

    public AbstructButton(String name) {
        this.name = name;
    }
}
