package com.story.code.component.tree.adaptor;

import com.story.code.component.tree.AbstractTreeNode;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/10 by Storys.Zhang
 */
@FunctionalInterface
public interface TreeMapConverter<T extends AbstractTreeNode<ID, T>, ID, TreeNodeMap> {

    /**
     * AbstractTreeNode to TreeNodeMap
     *
     * @param t
     * @return
     */
    TreeNodeMap convert(T t);

}
