package com.tqb.wx.utils;

/**
 * @ClassName MsgUtils
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/27 9:36
 * @Version v1.0
 */
public class MsgUtils {

    public static boolean isText(String msgType) {
        return msgType.equalsIgnoreCase("text");
    }

    public static boolean isImage(String msgType) {
        return msgType.equalsIgnoreCase("image");
    }

    public static boolean isVoice(String msgType) {
        return msgType.equalsIgnoreCase("voice");
    }

    public static boolean isShortVideo(String msgType) {
        return msgType.equalsIgnoreCase("shortvideo");
    }

    public static boolean isVideo(String msgType) {
        return msgType.equalsIgnoreCase("video");
    }

    public static boolean isLocation(String msgType) {
        return msgType.equalsIgnoreCase("location");
    }

    public static boolean isLink(String msgType) {
        return msgType.equalsIgnoreCase("link");
    }

    public static boolean isEvent(String msgType) {
        return msgType.equalsIgnoreCase("event");
    }

}
