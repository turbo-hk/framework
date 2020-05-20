package com.story.code.component.saveorupdate;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@FunctionalInterface
public interface ValidatorFunction<T> {

    /**
     * 验证
     *
     * @param t
     */
    void validate(T t);
}
