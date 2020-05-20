package com.story.code.component.collection.difference;

import java.util.Collection;
import java.util.List;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
public class CollectionDifferenceComponent<T> extends AbstractCollectionDifferenceComponent<T> {

    /**
     * 两个数组交集
     */
    private CollectionDifferenceFunction intersectionFunction;

    /**
     * source -> target两个数组查集
     */
    private CollectionDifferenceFunction sourceTargetDifferenceFunction;
    /**
     * target -> source两个数组查集
     */
    private CollectionDifferenceFunction targetSourceDifferenceFunction;

    /**
     * 并集不去重
     */
    private CollectionDifferenceFunction unionAllDifferenceFunction;
    /**
     * 并并集去重
     */
    private CollectionDifferenceFunction unionDistinctDifferenceFunction;

    public CollectionDifferenceComponent(Collection source, Collection target) {
        super(source, target);
    }

    public List<T> intersection() {
        return this.intersectionFunction.apply(this);
    }

    public List<T> sourceTargetDifference() {
        return this.sourceTargetDifferenceFunction.apply(this);
    }

    public List<T> targetSourceDifference() {
        return this.targetSourceDifferenceFunction.apply(this);
    }

    public List<T> unionALl() {
        return this.unionAllDifferenceFunction.apply(this);
    }

    public List<T> unionDistinct() {
        return this.unionDistinctDifferenceFunction.apply(this);
    }

    public CollectionDifferenceComponent<T> build() {
        return this.buildIntersectionFunction().buildSourceTargetDifferenceFunction().buildTargetSourceDifferenceFunction().buildUnionAllDifferenceFunction()
            .buildUnionDistinctDifferenceFunction();
    }

    public CollectionDifferenceComponent<T> buildIntersectionFunction() {
        this.intersectionFunction = IntersectionFunction::difference;
        return this;
    }

    public CollectionDifferenceComponent<T> buildSourceTargetDifferenceFunction() {
        this.sourceTargetDifferenceFunction = SourceTargetDifferenceFunction::difference;
        return this;
    }

    public CollectionDifferenceComponent<T> buildTargetSourceDifferenceFunction() {
        this.targetSourceDifferenceFunction = TargetSourceDifferenceFunction::difference;
        return this;
    }

    public CollectionDifferenceComponent<T> buildUnionAllDifferenceFunction() {
        this.unionAllDifferenceFunction = UnionAllDifferenceFunction::difference;
        return this;
    }

    public CollectionDifferenceComponent<T> buildUnionDistinctDifferenceFunction() {
        this.unionDistinctDifferenceFunction = UnionDistinctDifferenceFunction::difference;
        return this;
    }

}
