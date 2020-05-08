/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.param.sys.UserPageListParam;
import java.util.List;
import reactor.core.publisher.Mono;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:36 by Storys.Zhang
 */
public interface UserTunnelI extends AbstractTunnelI<UserDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 通过登录名称查询
     *
     * @param loginName
     * @param tenantId
     * @return
     */
    UserDO getByLoginName(String loginName, Long tenantId);

    /**
     * 分页数据
     *
     * @param query
     * @return
     */
    Mono<List<UserDO>> page(UserPageListParam query);

}