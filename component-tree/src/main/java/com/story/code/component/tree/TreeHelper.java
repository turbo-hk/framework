package com.story.code.component.tree;

import com.alibaba.fastjson.JSONObject;
import com.story.code.component.tree.adaptor.TreeMapConverter;
import com.story.code.component.tree.adaptor.TreeNodeFieldConfig;
import com.story.code.component.tree.adaptor.TreeNodeMap;
import com.story.code.helper.BeanMapperHelper;
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
public class TreeHelper {

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


    public static void main(String[] args) {
        MenuTreeNode treeNode = new MenuTreeNode();
        treeNode.setId(1L);
        treeNode.setParentId(0L);
        treeNode.setSortNo(6);
        treeNode.setLinkUrl("http://123456");
        MenuTreeNode treeNode2 = new MenuTreeNode();
        treeNode2.setId(2L);
        treeNode2.setParentId(0L);
        treeNode2.setSortNo(2);
        MenuTreeNode treeNode3 = new MenuTreeNode();
        treeNode3.setId(3L);
        treeNode3.setParentId(0L);
        treeNode3.setSortNo(4);

        MenuTreeNode treeNode11 = new MenuTreeNode();
        treeNode11.setId(11L);
        treeNode11.setParentId(1L);
        treeNode11.setSortNo(6);
        MenuTreeNode treeNode12 = new MenuTreeNode();
        treeNode12.setId(12L);
        treeNode12.setParentId(1L);
        treeNode12.setSortNo(67);

        MenuTreeNode treeNode122 = new MenuTreeNode();
        treeNode122.setId(122L);
        treeNode122.setParentId(12L);
        treeNode122.setSortNo(4);
        MenuTreeNode treeNode123 = new MenuTreeNode();
        treeNode123.setId(123L);
        treeNode123.setParentId(12L);
        treeNode123.setSortNo(2);
        MenuTreeNode treeNode124 = new MenuTreeNode();
        treeNode124.setId(124L);
        treeNode124.setParentId(12L);
        treeNode124.setSortNo(4);

        List<MenuTreeNode> dataList = new ArrayList<>();
        dataList.add(treeNode);
        dataList.add(treeNode2);
        dataList.add(treeNode3);

        dataList.add(treeNode11);
        dataList.add(treeNode12);
        dataList.add(treeNode122);
        dataList.add(treeNode123);
        dataList.add(treeNode124);

        List<MenuTreeNode> build = build(dataList, 0L, source -> {
            MenuTreeNode target = new MenuTreeNode();
            BeanMapperHelper.copy(source, target);
            return target;
        });
        System.out.println(build);
        System.out.println(JSONObject.toJSON(build));

        TreeNodeFieldConfig treeNodeFieldConfig = new TreeNodeFieldConfig();
        treeNodeFieldConfig.buildDefault();
        System.out.println(treeNodeFieldConfig);
        List<TreeNodeMap<String, Object>> treeNodeMaps = buildTreeMap(dataList, 0L, menuTreeNode -> {
            TreeNodeMap<String, Object> map = new TreeNodeMap<>(treeNodeFieldConfig);
            return map.convert(menuTreeNode);
        }, treeNodeFieldConfig);

        System.out.println(JSONObject.toJSON(treeNodeMaps));

        //BeanMapperHelper.mapList(build, TreeNodeFieldConfig.class);

    }

}
