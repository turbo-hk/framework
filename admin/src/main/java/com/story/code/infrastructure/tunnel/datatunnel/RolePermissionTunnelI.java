/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.RolePermissionDO;
import java.util.List;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:29 by Storys.Zhang
*/
public interface RolePermissionTunnelI extends AbstractTunnelI<RolePermissionDO> {

    /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(Long id);

    /**
     * 查询角色权限
     *
     * @param roleIds
     * @return
     */
    List<RolePermissionDO> listByRoleIds(List<Long> roleIds);

}