/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.param.sys.UserPageListParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author storys.zhang@gmail.com
 *
 * Created at 2020-03-26 16:20:36 by Storys.Zhang
 */
public interface UserDAO extends AbstractDAO<UserDO> {

   /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(@Param("id") Long id);

    /**
     * 根据登录名称查询
     *
     * @param loginName
     * @param tenantId
     * @return
     */
    UserDO getByLoginName(@Param("loginName") String loginName, @Param("tenantId") Long tenantId);

    /**
     * 分页数据
     *
     * @param query
     * @return
     */
    List<UserDO> page(UserPageListParam query);
}