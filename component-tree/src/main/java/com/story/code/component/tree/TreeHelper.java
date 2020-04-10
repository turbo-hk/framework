package com.story.code.component.tree;

import com.story.code.component.tree.adaptor.TreeMapConverter;
import com.story.code.component.tree.adaptor.TreeNodeFieldConfig;
import com.story.code.component.tree.adaptor.TreeNodeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 树结构帮助类
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/9 by Storys.Zhang
 */
public final class TreeHelper {

    /**
     * 构建一颗数结构
     *
     * @param dataList
     * @param parentId
     * @param <ID>
     * @param <T>
     * @return
     */
    public static <ID, T extends AbstractTreeNode<ID, T>> List<T> build(List<T> dataList, ID parentId, TreeNodeConverter<T, ID> converter) {
        Map<ID, List<T>> dataListGroupMap = dataList.parallelStream().collect(Collectors.groupingBy(T::getParentId));
        return build(dataListGroupMap, parentId, converter);
    }

    public static <ID, T extends AbstractTreeNode<ID, T>> List<T> build(Map<ID, List<T>> dataListGroupMap, ID parentId, TreeNodeConverter<T, ID> converter) {
        return Optional.ofNullable(dataListGroupMap.get(parentId)).orElse(new ArrayList<>()).parallelStream().filter(p -> p.getParentId().equals(parentId))
            .sorted(T::compareTo).map(f ->
            {
                T convert = converter.convert(f);
                convert.setChildren(build(dataListGroupMap, f.getId(), converter));
                return convert;
            }).collect(Collectors.toList());
    }

    /**
     * 构建树结构
     *
     * @param dataList
     * @param parentId
     * @param converter
     * @param treeNodeFieldConfig
     * @param <ID>
     * @param <T>
     * @return
     */
    public static <ID, T extends AbstractTreeNode<ID, T>> List<TreeNodeMap<String, Object>> buildTreeMap(List<T> dataList, ID parentId,
        TreeMapConverter<T, ID, TreeNodeMap<String, Object>> converter, TreeNodeFieldConfig treeNodeFieldConfig) {
        Map<ID, List<T>> dataListGroupMap = dataList.parallelStream().collect(Collectors.groupingBy(T::getParentId));
        return buildTreeMap(dataListGroupMap, parentId, converter, treeNodeFieldConfig);
    }

    public static <ID, T extends AbstractTreeNode<ID, T>> List<TreeNodeMap<String, Object>> buildTreeMap(Map<ID, List<T>> dataListGroupMap, ID parentId,
        TreeMapConverter<T, ID, TreeNodeMap<String, Object>> converter, TreeNodeFieldConfig treeNodeFieldConfig) {
        return Optional.ofNullable(dataListGroupMap.get(parentId)).orElse(new ArrayList<>()).parallelStream().filter(p -> p.getParentId().equals(parentId))
            .sorted(T::compareTo).map(f -> {
                TreeNodeMap<String, Object> treeNodeMap = converter.convert(f);
                return treeNodeMap.putChildren(buildTreeMap(dataListGroupMap, f.getId(), converter, treeNodeFieldConfig));
            }).collect(Collectors.toList());
    }

}
