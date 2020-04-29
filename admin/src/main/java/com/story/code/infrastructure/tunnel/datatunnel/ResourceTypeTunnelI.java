/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceTypeDO;
import java.util.List;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:19 by Storys.Zhang
 */
public interface ResourceTypeTunnelI extends AbstractTunnelI<ResourceTypeDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询租户下所有的权限类型
     *
     * @param tenantId
     * @return
     */
    List<ResourceTypeDO> listByTenantId(Long tenantId);

}