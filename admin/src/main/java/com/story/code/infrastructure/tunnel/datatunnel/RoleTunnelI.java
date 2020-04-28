/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.RoleDO;


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
}