package com.story.code.helper;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/15 by Storys.Zhang
 */
public final class StringHelper {

    /**
     * 判断空，去除两边空格
     *
     * @param cs
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        return StringUtils.isBlank(cs);
    }

    /**
     * 判断不为空，去除两边空格
     *
     * @param cs
     * @return
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return StringUtils.isNotBlank(cs);
    }
}
