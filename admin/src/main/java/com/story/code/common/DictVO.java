package com.story.code.common;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/15 by Storys.Zhang
 */
public class DictVO<T> {

    private T value;

    private String name;

    public DictVO(T value, String name) {
        this.value = value;
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
