package com.tqb.common;

import lombok.Data;

/**
 * @ClassName WXResult
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/28 11:56
 * @Version v1.0
 */
@Data
public class WXResult<T> {
    private T t;
    private String status = "success";
    private String msg;

    public WXResult (T t, String status){
        this.t = t;
        this.status = status;
    }

    public WXResult (T t, String status, String msg){
        this.t = t;
        this.status = status;
        this.msg = msg;
    }

    public WXResult (T t){
        this.t = t;
    }

    public WXResult (){
    }
}
