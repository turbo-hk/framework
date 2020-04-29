package com.story.code.domain.sys.valueobject;

import com.story.code.component.tree.AbstractTreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单树
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/9 by Storys.Zhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuTreeNode extends AbstractTreeNode<Long, MenuTreeNode> {

    /**
     * 树节点链接
     */
    private String linkUrl;

    /**
     * 树节点图标
     */
    private String icon;

    /**
     * 备注
     */
    private String remarks;

}
