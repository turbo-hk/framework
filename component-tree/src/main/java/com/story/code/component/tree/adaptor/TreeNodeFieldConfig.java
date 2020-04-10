package com.story.code.component.tree.adaptor;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/10 by Storys.Zhang
 */
public class TreeNodeFieldConfig {

    private String treeId;
    private String treeSort;
    private String treeName;
    private String treeCode;
    private String treeChildren;
    private String treeParentId;

    public TreeNodeFieldConfig buildDefault() {
        this.treeId = "id";
        this.treeSort = "sortNo";
        this.treeName = "name";
        this.treeCode = "code";
        this.treeChildren = "children";
        this.treeParentId = "parentId";
        return this;
    }


    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getTreeSort() {
        return treeSort;
    }

    public void setTreeSort(String treeSort) {
        this.treeSort = treeSort;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public String getTreeChildren() {
        return treeChildren;
    }

    public void setTreeChildren(String treeChildren) {
        this.treeChildren = treeChildren;
    }

    public String getTreeParentId() {
        return treeParentId;
    }

    public void setTreeParentId(String treeParentId) {
        this.treeParentId = treeParentId;
    }

    @Override
    public String toString() {
        return "TreeNodeFieldConfig{" +
            "treeId='" + treeId + '\'' +
            ", treeSort='" + treeSort + '\'' +
            ", treeName='" + treeName + '\'' +
            ", treeCode='" + treeCode + '\'' +
            ", treeChildren='" + treeChildren + '\'' +
            ", treeParentId='" + treeParentId + '\'' +
            '}';
    }
}
