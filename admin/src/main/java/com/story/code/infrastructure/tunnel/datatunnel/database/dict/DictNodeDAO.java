/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.database.dict;

import com.story.code.infrastructure.tunnel.dataobject.dict.DictNodeDO;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author storys.zhang@gmail.com
 *
 * Created at 2020-05-08 15:05:01 by Storys.zhang
 */
public interface DictNodeDAO{

    /**
     * select object by id
     *
     * @param id
     * @return
     */
    DictNodeDO get(@Param("id") Long id);

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
    int insert(DictNodeDO record);

   /**
    * update
    *
    * @param record
    * @return
    */
    int update(DictNodeDO record);

    /**
     * 根据code查询
     *
     * @param code
     * @param tenantId
     * @return
     */
    DictNodeDO getByCode(@Param("code") String code, @Param("tenantId") Long tenantId);
}