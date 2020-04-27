package com.story.code.helper;

import java.util.UUID;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/24 by Storys.Zhang
 */
public class UuidHelper {

    /**
     * 生成随机32位uuid，去除-
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(uuid());
    }
}
