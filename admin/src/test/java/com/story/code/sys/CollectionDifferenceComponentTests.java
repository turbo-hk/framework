package com.story.code.sys;

import com.google.common.collect.Lists;
import com.story.code.component.collection.difference.CollectionDifferenceComponent;
import com.story.code.component.collection.difference.DataPersistCollectionDifferenceComponent;
import org.junit.Test;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
public class CollectionDifferenceComponentTests {


    @Test
    public void test1() {
        CollectionDifferenceComponent<String> component = new CollectionDifferenceComponent<String>(Lists.newArrayList("1", "2", "3"), Lists.newArrayList("6", "5", "4", "3"));
        component.build();
        System.out.println(component.intersection());
        System.out.println(component.sourceTargetDifference());
        System.out.println(component.targetSourceDifference());
        System.out.println(component.unionALl());
        System.out.println(component.unionDistinct());
    }

    @Test
    public void test(){
        DataPersistCollectionDifferenceComponent<String> component = new DataPersistCollectionDifferenceComponent<>(Lists.newArrayList("1", "2", "3"), Lists.newArrayList("6", "5", "4", "3"));
        component.build();
        System.out.println(component.add());
        System.out.println(component.update());
        System.out.println(component.delete());

    }
}
