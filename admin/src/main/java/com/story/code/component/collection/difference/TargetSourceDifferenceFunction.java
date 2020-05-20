package com.story.code.component.collection.difference;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
public class TargetSourceDifferenceFunction {

    public static <T> List<T> difference(AbstractCollectionDifferenceComponent<T> component) {
        return component.getTarget().stream().filter(p -> !component.getSource().contains(p)).collect(Collectors.toList());
    }
}
