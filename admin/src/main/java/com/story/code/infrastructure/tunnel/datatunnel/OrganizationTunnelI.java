/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.OrganizationDO;
import com.story.code.infrastructure.tunnel.param.sys.OrganizationPageListParam;
import java.util.List;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:19:52 by Storys.Zhang
 */
public interface OrganizationTunnelI extends AbstractTunnelI<OrganizationDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 分页数据
     *
     * @param param
     * @return
     */
    List<OrganizationDO> pageList(OrganizationPageListParam param);
}