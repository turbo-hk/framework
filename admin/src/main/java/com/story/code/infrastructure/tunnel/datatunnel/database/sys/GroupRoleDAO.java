/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.GroupRoleDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author storys.zhang@gmail.com
 *
 * Created at 2020-03-26 16:19:40 by Storys.Zhang
 */
public interface GroupRoleDAO extends AbstractDAO<GroupRoleDO> {

   /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(@Param("id") Long id);

    /**
     * 用户组角色列表
     *
     * @param groupIds
     * @return
     */
    List<GroupRoleDO> listByGroupIds(@Param("groupIds") List<Long> groupIds);
}