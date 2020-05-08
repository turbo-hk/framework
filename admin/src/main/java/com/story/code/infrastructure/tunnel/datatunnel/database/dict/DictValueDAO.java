/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.database.dict;

import com.story.code.infrastructure.tunnel.dataobject.dict.DictValueDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author storys.zhang@gmail.com
 *
 * Created at 2020-05-08 15:05:40 by Storys.zhang
 */
public interface DictValueDAO{

    /**
     * select object by id
     *
     * @param id
     * @return
     */
    DictValueDO get(@Param("id") Long id);

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
    int insert(DictValueDO record);

   /**
    * update
    *
    * @param record
    * @return
    */
    int update(DictValueDO record);

    /**
     * 查询字典键值对
     *
     * @param nodeId
     * @return
     */
    List<DictValueDO> listByNodeId(@Param("nodeId") Long nodeId);
}