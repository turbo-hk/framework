package com.story.code.component.collection.difference;

import java.util.Collection;
import lombok.Getter;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
public abstract class AbstractCollectionDifferenceComponent<T> {
    @Getter
    private Collection<T> source;

    @Getter
    private Collection<T> target;

    public AbstractCollectionDifferenceComponent(Collection<T> source, Collection<T> target) {
        this.source = source;
        this.target = target;
    }
}
