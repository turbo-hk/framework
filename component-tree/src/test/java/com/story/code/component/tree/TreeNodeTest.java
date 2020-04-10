package com.story.code.component.tree;

import com.alibaba.fastjson.JSONObject;
import com.story.code.helper.BeanMapperHelper;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/10 by Storys.Zhang
 */
public class TreeNodeTest {

    @Test
    public void testMenuTree(){
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

        List<MenuTreeNode> build = TreeHelper.build(dataList, 0L, source -> {
            MenuTreeNode target = new MenuTreeNode();
            BeanMapperHelper.copy(source, target);
            return target;
        });
        System.out.println(build);
        System.out.println(JSONObject.toJSON(build));
    }

}
