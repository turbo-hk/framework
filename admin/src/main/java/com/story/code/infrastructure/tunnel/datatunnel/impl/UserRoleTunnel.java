/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import static com.story.code.infrastructure.tunnel.common.Constants.DEFAULT_LONG;

import com.story.code.helper.CollectionHelper;
import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserRoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserRoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.UserRoleDAO;
import java.util.List;
import java.util.Objects;
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
    public int deleteByUserIdAndRoleId(Long userId, Long roleId) {
        return dao.deleteByUserIdAndRoleId(userId, roleId);
    }

    @Override
    public List<UserRoleDO> listByUserId(Long userId) {
        if (Objects.isNull(userId) || DEFAULT_LONG == userId.longValue()) {
            return CollectionHelper.EMPTY;
        }
        return dao.listByUserId(userId);
    }

}