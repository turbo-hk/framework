package com.story.code.helper;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections.CollectionUtils;

/**
 * 集合工具类统一处理
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/7 by Storys.Zhang
 */
public class CollectionHelper {

    /**
     * 空集合
     */
    public static List EMPTY = Collections.emptyList();

    /**
     * 判断集合为空或null
     *
     * @param coll
     * @return
     */
    public static boolean isEmpty(Collection coll) {
        return CollectionUtils.isEmpty(coll);
    }

    /**
     * 判断集合不为空
     *
     * @param coll
     * @return
     */
    public static boolean isNotEmpty(Collection coll) {
        return CollectionUtils.isNotEmpty(coll);
    }

    /**
     * 集合内添加对象
     *
     * @param list
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> add(List<T> list, T... t) {
        if (Objects.isNull(list)) {
            list = Lists.newArrayList();
        }
        if (null == t || t.length == 0) {
            return list;
        }
        for (T e : t) {
            if (Objects.isNull(e)) {
                continue;
            }
            list.add(e);
        }
        return list;
    }
}
