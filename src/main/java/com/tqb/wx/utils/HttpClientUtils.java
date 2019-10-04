package com.tqb.wx.utils;


import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName HttpClientUtils
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 11:31
 * @Version v1.0
 */
public class HttpClientUtils {
    public static String get(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(get);
        String s = EntityUtils.toString(response.getEntity(), "UTF-8");
        response.close();
        httpClient.close();
        return s;
    }


    public static String post(String url, String jsonData) throws IOException {
        System.out.println(url);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json;charset=utf8");
        StringEntity stringEntity = new StringEntity(jsonData, "UTF-8");
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        String s = EntityUtils.toString(response.getEntity(), "UTF-8");
        response.close();
        httpClient.close();
        return s;
    }

    public static String ocrPost(String url,String urlEncode) throws IOException {
        System.out.println(url);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/x-www-form-urlencoded");
        StringEntity stringEntity = new StringEntity(urlEncode, "UTF-8");
        stringEntity.setContentType("application/json");
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        String s = EntityUtils.toString(response.getEntity(), "UTF-8");
        response.close();
        httpClient.close();
        return s;
    }
}
