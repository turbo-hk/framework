/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.UserDAO;
import com.story.code.infrastructure.tunnel.param.sys.UserPageListParam;
import java.util.List;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:36 by Storys.Zhang
*/
@Component
public class UserTunnel extends AbstractTunnel<UserDO, UserDAO> implements UserTunnelI{

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public UserDO getByLoginName(String loginName, Long tenantId) {
        return dao.getByLoginName(loginName, tenantId);
    }

    @Override
    public Mono<List<UserDO>> page(UserPageListParam query) {
        return Mono.justOrEmpty(dao.page(query));
    }

}