package com.story.code.component.tree;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/9 by Storys.Zhang
 */
@FunctionalInterface
public interface TreeNodeConverter<T extends AbstractTreeNode, ID> {

    /**
     * 数据转换
     *
     * @param source
     * @return
     */
    T convert(T source);

}
