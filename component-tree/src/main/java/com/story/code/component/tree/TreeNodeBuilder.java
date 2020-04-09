package com.story.code.component.tree;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/9 by Storys.Zhang
 */
@FunctionalInterface
public interface TreeNodeBuilder<T extends AbstractTreeNode<ID>, ID> {

    /**
     * 创建实例
     *
     * @return
     */
    public T instance();

}
