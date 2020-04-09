/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import com.story.code.infrastructure.tunnel.query.sys.MenuPageListQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:00 by Storys.Zhang
 */
public interface ResourceMenuDAO extends AbstractDAO<ResourceMenuDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(@Param("id") Long id);

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    List<ResourceMenuDO> pageList(MenuPageListQuery query);
}