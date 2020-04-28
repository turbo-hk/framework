/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserRoleDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author storys.zhang@gmail.com
 *
 * Created at 2020-03-26 16:21:17 by Storys.Zhang
 */
public interface UserRoleDAO extends AbstractDAO<UserRoleDO> {

   /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(@Param("id") Long id);

    /**
     * 用户关联的角色
     *
     * @param userId
     * @return
     */
    List<UserRoleDO> listByUserId(Long userId);
}