package com.story.code.component.tree.vo;

import java.util.List;
import java.util.Optional;
import javax.swing.tree.TreeNode;

/**
 * 树结构
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/9 by Storys.Zhang
 */
public abstract class AbstractTreeNode<ID> implements Comparable<AbstractTreeNode> {

    /**
     * 树节点ID
     */
    private ID id;

    /**
     * 父节点ID
     */
    private ID parentId;

    /**
     * 树节点名称
     */
    private String name;

    /**
     * 树节点编码
     */
    private String code;

    /**
     * 排序字段
     */
    private Integer sortNo;

    /**
     * 树节点链接
     */
    private String linkUrl;

    /**
     * 树节点图标
     */
    private String icon;

    /**
     * 子菜单
     */
    private List<TreeNode> children;

    @Override
    public int compareTo(AbstractTreeNode o) {
        return Optional.ofNullable(this.getSortNo()).orElse(0).compareTo(Optional.ofNullable(o.getSortNo()).orElse(0));
    }


    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ID getParentId() {
        return parentId;
    }

    public void setParentId(ID parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}
