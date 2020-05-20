/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.AbstractTunnelI;
import com.story.code.infrastructure.tunnel.dataobject.sys.GroupDO;
import com.story.code.infrastructure.tunnel.param.sys.GroupPageListParam;
import java.util.List;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:19:00 by Storys.Zhang
 */
public interface GroupTunnelI extends AbstractTunnelI<GroupDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询一个组下面所有的子组
     *
     * @param parentId
     * @return
     */
    List<GroupDO> listChildren(Long parentId);

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    List<GroupDO> pageList(GroupPageListParam param);
}