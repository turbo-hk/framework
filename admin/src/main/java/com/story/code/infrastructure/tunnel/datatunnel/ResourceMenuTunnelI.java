/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import com.story.code.infrastructure.tunnel.query.sys.MenuPageListQuery;
import java.util.List;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:00 by Storys.Zhang
 */
public interface ResourceMenuTunnelI extends AbstractTunnelI<ResourceMenuDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    List<ResourceMenuDO> pageList(MenuPageListQuery query);

    /**
     * 根据id集合查询多个对象
     *
     * @param ids
     * @return
     */
    List<ResourceMenuDO> listByIds(List<Long> ids);

}