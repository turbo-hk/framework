package com.story.code.component.collection.difference;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
public class UnionAllDifferenceFunction {

    public static <T> List<T> difference(AbstractCollectionDifferenceComponent<T> component) {
        List<T> unionAll = component.getSource().parallelStream().collect(Collectors.toList());
        unionAll.addAll(component.getTarget().parallelStream().collect(Collectors.toList()));
        return unionAll;
    }
}
