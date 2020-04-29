package com.story.code.domain.sys.converter;

import com.story.code.domain.sys.valueobject.MenuTreeNode;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/29 by Storys.Zhang
 */
@Component
public class MenuConverter {

    public MenuTreeNode doToNode(ResourceMenuDO data) {
        MenuTreeNode node = new MenuTreeNode();
        node.setLinkUrl(data.getUrl());
        node.setIcon(data.getIcon());
        node.setRemarks(data.getRemarks());
        node.setId(data.getId());
        node.setParentId(data.getParentId());
        node.setName(data.getTitle());
        node.setCode(data.getId().toString());
        node.setSortNo(data.getRankNum().intValue());

        return node;
    }
}
