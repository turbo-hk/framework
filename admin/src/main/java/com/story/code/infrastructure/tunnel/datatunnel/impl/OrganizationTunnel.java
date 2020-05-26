/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.OrganizationDO;
import com.story.code.infrastructure.tunnel.datatunnel.OrganizationTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.OrganizationDAO;
import com.story.code.infrastructure.tunnel.param.sys.OrganizationPageListParam;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:19:52 by Storys.Zhang
 */
@Component
public class OrganizationTunnel extends AbstractTunnel<OrganizationDO, OrganizationDAO> implements OrganizationTunnelI {

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<OrganizationDO> pageList(OrganizationPageListParam param) {
        return dao.pageList(param);
    }

}