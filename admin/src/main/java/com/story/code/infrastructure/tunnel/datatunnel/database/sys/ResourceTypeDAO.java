/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceTypeDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:19 by Storys.Zhang
 */
public interface ResourceTypeDAO extends AbstractDAO<ResourceTypeDO> {

    /**
     * delete object by id
     *
     * @param id
     * @return
     */
    int delete(@Param("id") Long id);

    /**
     * 根据租户id查询权限类型
     *
     * @param tenantId
     * @return
     */
    List<ResourceTypeDO> listByTenantId(@Param("tenantId") Long tenantId);

}