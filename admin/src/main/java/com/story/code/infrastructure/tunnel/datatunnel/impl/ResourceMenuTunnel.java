/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourceMenuTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.ResourceMenuDAO;
import com.story.code.infrastructure.tunnel.query.sys.MenuPageListQuery;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:00 by Storys.Zhang
 */
@Component
public class ResourceMenuTunnel extends AbstractTunnel<ResourceMenuDO, ResourceMenuDAO> implements ResourceMenuTunnelI {

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<ResourceMenuDO> pageList(MenuPageListQuery query) {
        return dao.pageList(query);
    }

}