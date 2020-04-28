/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.helper.CollectionHelper;
import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.RoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.RoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.RoleDAO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:24 by Storys.Zhang
 */
@Component
public class RoleTunnel extends AbstractTunnel<RoleDO, RoleDAO> implements RoleTunnelI {


    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<RoleDO> listByIds(List<Long> ids) {
        if (CollectionHelper.isEmpty(ids)) {
            return CollectionHelper.EMPTY;
        }
        return dao.listByIds(ids);
    }

}