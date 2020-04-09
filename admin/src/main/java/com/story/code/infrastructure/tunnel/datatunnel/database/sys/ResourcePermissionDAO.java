/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.database.sys;

import com.story.code.infrastructure.tunnel.dataobject.sys.ResourcePermissionDO;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author storys.zhang@gmail.com
 *
 * Created at 2020-03-26 16:20:14 by Storys.Zhang
 */
public interface ResourcePermissionDAO{

    /**
     * select object by id
     *
     * @param id
     * @return
     */
    ResourcePermissionDO get(@Param("id") Long id);

   /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(@Param("id") Long id);

   /**
    * insert
    *
    * @param record
    * @return
    */
    int insert(ResourcePermissionDO record);

   /**
    * update
    *
    * @param record
    * @return
    */
    int update(ResourcePermissionDO record);
}