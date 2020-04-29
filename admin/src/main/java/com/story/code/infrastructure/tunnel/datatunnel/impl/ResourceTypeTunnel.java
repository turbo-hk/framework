/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceTypeDO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourceTypeTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.ResourceTypeDAO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:19 by Storys.Zhang
 */
@Component
public class ResourceTypeTunnel extends AbstractTunnel<ResourceTypeDO, ResourceTypeDAO> implements ResourceTypeTunnelI {

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<ResourceTypeDO> listByTenantId(Long tenantId) {
        return dao.listByTenantId(tenantId);
    }

}