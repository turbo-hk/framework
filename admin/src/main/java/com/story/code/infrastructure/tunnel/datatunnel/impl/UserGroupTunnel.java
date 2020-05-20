/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import static com.story.code.infrastructure.tunnel.common.Constants.DEFAULT_LONG;

import com.story.code.helper.CollectionHelper;
import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserGroupDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserGroupTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.UserGroupDAO;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:41 by Storys.Zhang
 */
@Component
public class UserGroupTunnel extends AbstractTunnel<UserGroupDO, UserGroupDAO> implements UserGroupTunnelI {


    @Override
    public int deleteByUserIdAndGroupId(Long userId, Long groupId) {
        return dao.deleteByUserIdAndGroupId(userId, groupId);
    }

    @Override
    public List<UserGroupDO> listByUserId(Long userId) {
        if (Objects.isNull(userId) || DEFAULT_LONG == userId.longValue()) {
            return CollectionHelper.EMPTY;
        }
        return dao.listByUserId(userId);
    }

}