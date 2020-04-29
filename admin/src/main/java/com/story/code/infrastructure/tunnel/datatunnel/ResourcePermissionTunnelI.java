/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourcePermissionDO;
import java.util.List;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:14 by Storys.Zhang
 */
public interface ResourcePermissionTunnelI extends AbstractTunnelI<ResourcePermissionDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 根据id集合查询多个对象
     *
     * @param ids
     * @return
     */
    List<ResourcePermissionDO> listByIds(List<Long> ids);

}