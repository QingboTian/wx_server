package com.tqb.wx.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Button
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 12:38
 * @Version v1.0
 */
@Data
public class Button {
    private List<AbstructButton> button = new ArrayList<>();
}
