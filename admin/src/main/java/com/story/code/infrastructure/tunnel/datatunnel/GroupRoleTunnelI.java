/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.GroupRoleDO;
import java.util.List;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:19:40 by Storys.Zhang
*/
public interface GroupRoleTunnelI extends AbstractTunnelI<GroupRoleDO> {

    /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(Long id);

    /**
     * 用户组对应的角色列表
     *
     * @param groupId
     * @return
     */
    List<GroupRoleDO> listByGroupId(Long groupId);
}