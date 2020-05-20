package com.story.code.component.collection.difference;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
public class SourceTargetDifferenceFunction {

    public static <T> List<T> difference(AbstractCollectionDifferenceComponent<T> component) {
        return component.getSource().stream().filter(p -> !component.getTarget().contains(p)).collect(Collectors.toList());
    }
}
