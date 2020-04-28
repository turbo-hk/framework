/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserRoleDO;
import java.util.List;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:21:17 by Storys.Zhang
 */
public interface UserRoleTunnelI extends AbstractTunnelI<UserRoleDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 用户关联的所有角色
     *
     * @param userId
     * @return
     */
    List<UserRoleDO> listByUserId(Long userId);
}