/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.helper.CollectionHelper;
import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourcePermissionDO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourcePermissionTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.ResourcePermissionDAO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:14 by Storys.Zhang
*/
@Component
public class ResourcePermissionTunnel extends AbstractTunnel<ResourcePermissionDO, ResourcePermissionDAO> implements ResourcePermissionTunnelI{

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public List<ResourcePermissionDO> listByIds(List<Long> ids) {
        if (CollectionHelper.isEmpty(ids)){
            return CollectionHelper.EMPTY;
        }
        return dao.listByIds(ids);
    }

}