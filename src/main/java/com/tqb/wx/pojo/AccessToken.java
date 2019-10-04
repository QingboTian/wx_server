package com.tqb.wx.pojo;

import lombok.Data;

/**
 * @ClassName AccessToken
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 11:19
 * @Version v1.0
 */
@Data
public class AccessToken {
    private String access_token;
    private String expires_in;
    private Long overtime;

    public AccessToken(String access_token, String expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.overtime = System.currentTimeMillis() + Long.parseLong(expires_in) * 1000;
    }

    // 是否过期
    public boolean isExpires(){
        return System.currentTimeMillis() > overtime;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", overtime=" + overtime +
                '}';
    }
}
