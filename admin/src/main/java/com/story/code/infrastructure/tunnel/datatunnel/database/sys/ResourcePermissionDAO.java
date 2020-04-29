/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.AbstractDAO;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourcePermissionDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author storys.zhang@gmail.com
 *
 * Created at 2020-03-26 16:20:14 by Storys.Zhang
 */
public interface ResourcePermissionDAO extends AbstractDAO<ResourcePermissionDO> {

   /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(@Param("id") Long id);

    /**
     * 根据多个id查询数据
     *
     * @param ids
     * @return
     */
    List<ResourcePermissionDO> listByIds(@Param("ids") List<Long> ids);
}