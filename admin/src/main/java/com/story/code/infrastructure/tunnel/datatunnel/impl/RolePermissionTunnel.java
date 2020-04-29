/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.helper.CollectionHelper;
import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.RolePermissionDO;
import com.story.code.infrastructure.tunnel.datatunnel.RolePermissionTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.RolePermissionDAO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:29 by Storys.Zhang
 */
@Component
public class RolePermissionTunnel extends AbstractTunnel<RolePermissionDO, RolePermissionDAO> implements RolePermissionTunnelI {

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<RolePermissionDO> listByRoleIds(List<Long> roleIds) {
        if (CollectionHelper.isEmpty(roleIds)){
            return CollectionHelper.EMPTY;
        }
        return dao.listByRoleIds(roleIds);
    }



}