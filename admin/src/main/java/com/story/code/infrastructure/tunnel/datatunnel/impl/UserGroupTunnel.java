/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserGroupDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserGroupTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.UserGroupDAO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:41 by Storys.Zhang
 */
@Component
public class UserGroupTunnel extends AbstractTunnel<UserGroupDO, UserGroupDAO> implements UserGroupTunnelI {


    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<UserGroupDO> listByUserId(Long userId) {
        return dao.listByUserId(userId);
    }

}