package com.story.code.helper;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.primitives.Chars;

/**
 * 生成树结构的字符串字符串的结构为
 * <p>
 * a001
 * <p>
 * a001a001
 * <p>
 * a001a001a001
 * <p>
 * a001a001a001a999
 * <p>
 * 字符串有一个字母开头（一共24个字母）
 * <p>
 * 后面跟MAX_LENGTH长度的数字长度不够前置补0
 * <p>
 * 一个层次支持的数据总个数为MAX_LENGTH=1则24*10, MAX_LENGTH=2则24*100依次类推超过最大个数报错
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/30 by Storys.Zhang
 */
public final class OrganizationUidGenerator {

    public final static String LETTER_CHARS = "abcdefghijkmnpqrstuvwxyz";

    public final static String DIGIT_CHARS = "0123456789";

    private static int MAX_LENGTH = 3;

    /**
     * 生成树结构的key
     *
     * @param parentUid
     * @param maxUid
     * @return
     */
    public static String generate(String parentUid, String maxUid) {
        if (StringHelper.isBlank(parentUid) && StringHelper.isBlank(maxUid)) {
            return generateRoot(maxUid);
        }
        if (StringHelper.isBlank(parentUid)) {
            return generateRoot(maxUid);
        }
        if (StringHelper.isNotBlank(parentUid)) {
            return generateChildren(parentUid, maxUid);
        }
        return null;
    }

    /**
     * 根节点
     *
     * @param maxUid
     * @return
     */
    public static String generateRoot(String maxUid) {
        if (StringHelper.isBlank(maxUid)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(LETTER_CHARS.charAt(0));
            stringBuffer.append(Character.toString(DIGIT_CHARS.charAt(0)).repeat(MAX_LENGTH));
            return stringBuffer.toString();
        }
        Preconditions.checkArgument(maxUid.length() == MAX_LENGTH + 1);
        char letter = maxUid.charAt(0);
        int digit = Integer.parseInt(maxUid.substring(1, maxUid.length()));
        ++digit;
        if (String.valueOf(digit).length() <= MAX_LENGTH) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(letter);
            stringBuffer.append(Strings.padStart(String.valueOf(digit), MAX_LENGTH, '0'));
            return stringBuffer.toString();
        }
        return generateNextSibling(StringHelper.EMPTY, letter);
    }

    /**
     * 子集后面拼接两位数字
     *
     * @param maxUid
     * @return
     */
    public static String generateChildren(String parentUid, String maxUid) {
        if (StringHelper.isBlank(maxUid)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(parentUid);
            stringBuffer.append(LETTER_CHARS.charAt(0));
            stringBuffer.append(Character.toString(DIGIT_CHARS.charAt(0)).repeat(MAX_LENGTH));
            return stringBuffer.toString();
        }
        String childrenUid = maxUid.substring(parentUid.length(), maxUid.length());
        char letter = childrenUid.charAt(0);
        int digit = Integer.parseInt(childrenUid.substring(1, childrenUid.length()));
        ++digit;
        if (String.valueOf(digit).length() <= MAX_LENGTH) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(parentUid);
            stringBuffer.append(letter);
            stringBuffer.append(Strings.padStart(String.valueOf(digit), MAX_LENGTH, '0'));
            return stringBuffer.toString();
        }
        return generateNextSibling(parentUid, letter);
    }

    private static String generateNextSibling(String parentUid, char letter) {
        int indexOf = Chars.lastIndexOf(LETTER_CHARS.toCharArray(), letter);
        Preconditions.checkArgument(indexOf <= LETTER_CHARS.length());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(parentUid);
        stringBuffer.append(LETTER_CHARS.toCharArray()[indexOf + 1]);
        stringBuffer.append(Character.toString(DIGIT_CHARS.charAt(0)).repeat(MAX_LENGTH));
        return stringBuffer.toString();
    }

}
