/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.RolePermissionDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author storys.zhang@gmail.com
 *
 * Created at 2020-03-26 16:20:29 by Storys.Zhang
 */
public interface RolePermissionDAO extends AbstractDAO<RolePermissionDO> {


   /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(@Param("id") Long id);

    /**
     * 查询角色对应的权限
     *
     * @param roleIds
     * @return
     */
    List<RolePermissionDO> listByRoleIds(@Param("roleIds")List<Long> roleIds);
}