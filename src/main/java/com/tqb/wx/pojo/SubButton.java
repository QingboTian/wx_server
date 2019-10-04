package com.tqb.wx.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubButton
 * @Description: 子菜单
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 15:32
 * @Version v1.0
 */
@Data
public class SubButton extends AbstructButton {
    private List<AbstructButton> sub_button = new ArrayList<>();

    public SubButton(String name) {
        super(name);
    }
}
