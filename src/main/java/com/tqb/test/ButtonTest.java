package com.tqb.test;

import com.tqb.wx.pojo.*;
import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * @ClassName ButtonTest
 * @Description: 自定义菜单测试类
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 12:40
 * @Version v1.0
 */
public class ButtonTest {
    @Test
    public void test(){
        Button button = new Button();
        button.getButton().add(new ClickButton("一级点击", "1"));
        button.getButton().add(new ViewButton("调查系统", "http://132.232.203.84:8080/ques-sys"));
        SubButton sub_button = new SubButton("子菜单");
        sub_button.getSub_button().add(new ClickButton("点击子菜单", "31"));
        sub_button.getSub_button().add(new ViewButton("跳转子菜单", "http://www.baidu.com"));
        button.getButton().add(sub_button);
        JSONObject jsonObject = JSONObject.fromObject(button);
        System.out.println(jsonObject.toString());
    }
}
