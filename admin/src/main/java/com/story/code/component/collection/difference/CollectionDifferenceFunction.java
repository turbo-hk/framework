package com.story.code.component.collection.difference;

import java.util.List;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
@FunctionalInterface
public interface CollectionDifferenceFunction {

    /**
     * 执行
     *
     * @param component
     * @param <T>
     * @return
     */
    <T> List<T> apply(AbstractCollectionDifferenceComponent<T> component);
}
