package com.tqb.wx.controller;

import com.tqb.wx.pojo.Button;
import com.tqb.wx.pojo.ClickButton;
import com.tqb.wx.pojo.SubButton;
import com.tqb.wx.pojo.ViewButton;
import com.tqb.wx.utils.HttpClientUtils;
import com.tqb.wx.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import java.io.IOException;

/**
 * @ClassName CreateMenuMain
 * @Description: 用于创建自定义菜单
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 15:58
 * @Version v1.0
 */
@Slf4j
public class CreateMenuMain {
    private static final String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public static void main(String[] args) {
        Button button = new Button();
        SubButton subButton1 = new SubButton("西邮校园");
        subButton1.getSub_button().add(new ClickButton("西邮导航","11"));
        subButton1.getSub_button().add(new ClickButton("西邮地图","12"));
        subButton1.getSub_button().add(new ClickButton("快速评教","13"));
        subButton1.getSub_button().add(new ClickButton("文字识别",  "14"));
        button.getButton().add(subButton1);
        SubButton subButton2 = new SubButton("查询成绩");
        subButton2.getSub_button().add(new ViewButton("快速查询", "http://bobo.free.idcfengye.com/searchScore.html"));
        subButton2.getSub_button().add(new ViewButton("官网查询", "http://www.xiyou.edu.cn/"));
        button.getButton().add(subButton2);
        SubButton subButton3 = new SubButton("关于作者");
        subButton3.getSub_button().add(new ViewButton("Github","https://github.com/QingboTian"));
        subButton3.getSub_button().add(new ViewButton("博客","https://blog.csdn.net/weixin_42061805"));
        subButton3.getSub_button().add(new ClickButton("联系作者","33"));
        button.getButton().add(subButton3);
        JSONObject jsonObject = JSONObject.fromObject(button);
        String accessToken = new TokenUtils().getAccessToken();
        System.out.println(jsonObject.toString());
        try {
            String access_token = HttpClientUtils.post(url.replace("ACCESS_TOKEN", accessToken), jsonObject.toString());
            //JSONObject jsonObject1 = JSONObject.fromObject(access_token);
            /*String errcode = jsonObject.getString("errcode");
            if (errcode.equals("0"))
                log.info("-------------------创建菜单成功------------------");
            else{
                log.error("-------------------创建菜单失败------------------");
                log.error(jsonObject1.toString());
            }*/
            System.out.println(access_token);
        } catch (IOException e) {
            log.error("-------------------创建菜单失败------------------");
            e.printStackTrace();
        }
    }
}
