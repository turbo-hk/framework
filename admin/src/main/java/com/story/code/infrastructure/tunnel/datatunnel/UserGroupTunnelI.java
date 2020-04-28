/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserGroupDO;
import java.util.List;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:41 by Storys.Zhang
 */
public interface UserGroupTunnelI extends AbstractTunnelI<UserGroupDO> {


    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     *  查询用户组列表
     *
     * @param userId
     * @return
     */
    List<UserGroupDO> listByUserId(Long userId);
}