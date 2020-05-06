/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.google.common.collect.Lists;
import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.GroupDO;
import com.story.code.infrastructure.tunnel.datatunnel.GroupTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.GroupDAO;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:19:00 by Storys.Zhang
 */
@Component
public class GroupTunnel extends AbstractTunnel<GroupDO, GroupDAO> implements GroupTunnelI {


    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<GroupDO> listChildren(Long parentId) {
        List<GroupDO> flatList = Lists.newArrayList();
        List<GroupDO> children = dao.listByParentId(parentId);
        getChildren(children, flatList);
        return flatList;
    }

    private void getChildren(List<GroupDO> children, List<GroupDO> flatList) {
        children.stream().forEach(groupDO -> {
            flatList.add(groupDO);
            List<GroupDO> groupDOS = dao.listByParentId(groupDO.getId());
            if (groupDOS.size() == 0) {
                return;
            }
            getChildren(groupDOS, flatList);
            flatList.addAll(groupDOS);
        });
    }
}