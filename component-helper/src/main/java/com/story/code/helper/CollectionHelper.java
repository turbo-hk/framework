package com.story.code.helper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
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

}
