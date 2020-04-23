package com.story.code.helper;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/23 by Storys.Zhang
 */
public final class Base64Helper {

    /**
     * 字符串解码
     *
     * @param str
     * @return
     */
    public static byte[] decode(String str){
        return java.util.Base64.getDecoder().decode(str);
    }

    /**
     * 解码成字符串
     *
     * @param str
     * @return
     */
    public static String encode(byte[] str){
        return java.util.Base64.getEncoder().encodeToString(str);
    }
}
