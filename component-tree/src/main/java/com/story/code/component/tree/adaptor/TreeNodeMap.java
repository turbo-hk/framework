package com.story.code.component.tree.adaptor;

import com.story.code.component.tree.AbstractTreeNode;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/10 by Storys.Zhang
 */
public class TreeNodeMap<K, V> extends HashMap<K, V> {

    private TreeNodeFieldConfig treeNodeFieldConfig;

    public TreeNodeMap(TreeNodeFieldConfig treeNodeFieldConfig) {
        this.treeNodeFieldConfig = treeNodeFieldConfig;
    }

    public <ID, T extends AbstractTreeNode<ID, T>> TreeNodeMap<K, V> convert(T treeNode) {
        Arrays.stream(treeNode.getClass().getSuperclass().getDeclaredFields()).parallel().forEach(c -> {
            String fieldName = c.getName();
            System.out.println(fieldName);
            switch (fieldName) {
                case "id":
                    super.put((K) treeNodeFieldConfig.getTreeId(), (V) treeNode.getId());
                    break;
                case "parentId":
                    super.put((K) treeNodeFieldConfig.getTreeParentId(), (V) treeNode.getParentId());
                    break;
                case "name":
                    super.put((K) treeNodeFieldConfig.getTreeName(), (V) treeNode.getName());
                    break;
                case "code":
                    super.put((K) treeNodeFieldConfig.getTreeCode(), (V) treeNode.getCode());
                    break;
                case "sortNo":
                    super.put((K) treeNodeFieldConfig.getTreeSort(), (V) treeNode.getSortNo());
                    break;
                case "children":
                    super.put((K) treeNodeFieldConfig.getTreeChildren(), (V) treeNode.getChildren());
                    break;
                default:
                    try {
                        c.setAccessible(true);
                        super.put((K) c.getName(), (V) c.get(treeNode));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        });

        Arrays.stream(treeNode.getClass().getDeclaredFields()).parallel().forEach(c -> {
            String fieldName = c.getName();
            try {
                c.setAccessible(true);
                super.put((K) c.getName(), (V) c.get(treeNode));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return this;
    }

    public TreeNodeMap<K, V> putChildren(V children) {
        super.put((K) treeNodeFieldConfig.getTreeChildren(), children);
        return this;
    }
}
