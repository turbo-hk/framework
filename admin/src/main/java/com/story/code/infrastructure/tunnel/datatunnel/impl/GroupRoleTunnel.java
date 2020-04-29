/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.helper.CollectionHelper;
import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.GroupRoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.GroupRoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.GroupRoleDAO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:19:40 by Storys.Zhang
 */
@Component
public class GroupRoleTunnel extends AbstractTunnel<GroupRoleDO, GroupRoleDAO> implements GroupRoleTunnelI {

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<GroupRoleDO> listByGroupIds(List<Long> groupIds) {
        if (CollectionHelper.isEmpty(groupIds)) {
            return CollectionHelper.EMPTY;
        }
        return dao.listByGroupIds(groupIds);
    }

}