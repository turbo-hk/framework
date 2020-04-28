/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserRoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserRoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.UserRoleDAO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:21:17 by Storys.Zhang
*/
@Component
public class UserRoleTunnel extends AbstractTunnel<UserRoleDO, UserRoleDAO> implements UserRoleTunnelI{

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public List<UserRoleDO> listByUserId(Long userId) {
        return dao.listByUserId(userId);
    }

}