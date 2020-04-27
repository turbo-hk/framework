package com.story.code.common.page;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/13 by Storys.Zhang
 */
@FunctionalInterface
public interface PageDataConverter<D, V> {

    /**
     * 数据转换
     *
     * @param data
     * @return
     */
    V convert(D data);
}
