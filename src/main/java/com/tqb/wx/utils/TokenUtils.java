package com.tqb.wx.utils;

import com.tqb.wx.pojo.AccessToken;
import net.sf.json.JSONObject;

import java.io.IOException;

/**
 * @ClassName TokenUtils
 * @Description: 获取access_token的工具类
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 16:03
 * @Version v1.0
 */
//@Slf4j
public class TokenUtils {

    //@Value("${ACCESS_TOKEN_URL}")
    private  String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&";
    //@Value("${APPSECRET}")
    //private static String APPSECRET = "4fc445f77bc57cc2b8fd602bbe94ba43";
    private static String APPSECRET = "609c4a56a17345ee0a1057ab0b66b279";
    //@Value("${APPID}")
    //private static String APPID = "wx03b24091cad2f51a";
    private static String APPID = "wx180ca5b1736a70f1";

    private static AccessToken at;

    // 获取access_token
    private void gettoken() {
        //ACCESS_TOKEN_URL.replace("APPSECRET", APPSECRET).replace("APPID", APPID);
        ACCESS_TOKEN_URL = ACCESS_TOKEN_URL + "appid=" + APPID + "&secret=" + APPSECRET;
        String response = null;
        try {
            response = HttpClientUtils.get(ACCESS_TOKEN_URL);
        } catch (IOException e) {
            // log.error("---------------------获取access_token失败-----------------------");
            System.out.println("---------------------获取access_token失败-----------------------");
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.fromObject(response);
        System.out.println(jsonObject.toString());
        String access_token = (String) jsonObject.getString("access_token");
        String expires_in = (String) jsonObject.getString("expires_in");
        at = new AccessToken(access_token, expires_in);
    }

    // 供外界调用的方法
    // 进行判断是否重新获取token
    public  String getAccessToken(){
        if (at == null || at.isExpires()){
            gettoken();
        }
        return at.getAccess_token();
    }
}
