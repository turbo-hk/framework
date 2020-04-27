package com.story.code.component.tree;

import java.util.List;
import java.util.Optional;

/**
 * 树结构
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/9 by Storys.Zhang
 */
public abstract class AbstractTreeNode<ID, T extends AbstractTreeNode> implements Comparable<T> {

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
     * 子菜单
     */
    private List<T> children;

    @Override
    public int compareTo(T o) {
        return Optional.ofNullable(this.sortNo).orElse(0).compareTo(Optional.ofNullable(o.getSortNo()).orElse(0));
    }

    @Override
    public String toString() {
        return "AbstractTreeNode{" +
            "id=" + id +
            ", parentId=" + parentId +
            ", name='" + name + '\'' +
            ", code='" + code + '\'' +
            ", sortNo=" + sortNo +
            ", children=" + children +
            '}';
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getParentId() {
        return parentId;
    }

    public void setParentId(ID parentId) {
        this.parentId = parentId;
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

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
