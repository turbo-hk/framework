package com.story.code.component.tree;

/**
 * 菜单树
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/9 by Storys.Zhang
 */
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "MenuTreeNode{" +
            "linkUrl='" + linkUrl + '\'' +
            ", icon='" + icon + '\'' +
            ", remarks='" + remarks + '\'' +
            "} " + super.toString();
    }
}
