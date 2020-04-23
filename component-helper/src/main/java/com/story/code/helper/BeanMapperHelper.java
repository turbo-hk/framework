package com.story.code.helper;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import org.dozer.DozerBeanMapper;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
public final class BeanMapperHelper {

    /**
     * 单例对象
     */
    private static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    /**
     * 基于Dozer转换对象的类型.
     *
     * @param source
     * @param destinationClass
     * @param <T>
     * @return
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        return dozerBeanMapper.map(source, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     *
     * @param sourceList
     * @param destinationClass
     * @param <T>
     * @return
     */
    public static <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass) {
        List<T> destinationList = Lists.newArrayList();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozerBeanMapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * 基于Dozer将对象A的值拷贝到对象B中.
     *
     * @param source
     * @param destinationObject
     */
    public static void copy(Object source, Object destinationObject) {
        dozerBeanMapper.map(source, destinationObject);
    }
}
