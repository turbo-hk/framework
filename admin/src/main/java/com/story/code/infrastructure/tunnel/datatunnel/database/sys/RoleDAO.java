/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.RoleDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:24 by Storys.Zhang
 */
public interface RoleDAO extends AbstractDAO<RoleDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(@Param("id") Long id);

    /**
     * 查询多个角色信息
     *
     * @param ids
     * @return
     */
    List<RoleDO> listByIds(@Param("ids") List<Long> ids);

    /**
     * 查询子角色
     *
     * @param parentId
     * @return
     */
    List<RoleDO> listByParentId(@Param("parentId") Long parentId);

}