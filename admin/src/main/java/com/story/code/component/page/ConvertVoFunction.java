package com.story.code.component.page;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@FunctionalInterface
public interface ConvertVoFunction<T, V> {

    /**
     * 转换
     *
     * @param t
     * @return
     */
    V convert(T t);
}
