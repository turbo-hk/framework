/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.RoleDO;
import com.story.code.infrastructure.tunnel.param.sys.RolePageListParam;
import java.util.List;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:24 by Storys.Zhang
*/
public interface RoleTunnelI extends AbstractTunnelI<RoleDO> {

    /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(Long id);

    /**
     * 查询多个角色ID
     *
     * @param ids
     * @return
     */
    List<RoleDO> listByIds(List<Long> ids);

    /**
     * 所有的子角色列表
     *
     * @param parentId
     * @return
     */
    List<RoleDO> listChildren(Long parentId);

    /**
     * 分页
     *
     * @param param
     * @return
     */
    List<RoleDO> pageList(RolePageListParam param);
}