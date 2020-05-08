/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.dataobject.dict.DictValueDO;
import java.util.List;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-05-08 15:05:40 by Storys.zhang
*/
public interface DictValueTunnelI{

    /**
    * select object by id
    *
    * @param id
    * @return
    */
    DictValueDO get(Long id);

    /**
    * delete object by id
    *
    * @param id
    * @return
    */
    int delete(Long id);

    /**
    * create
    *
    * @param record
    * @return
    */
    int create(DictValueDO record);

    /**
    * update
    *
    * @param record
    * @return
    */
    int update(DictValueDO record);

    /**
     * 查询字典键值
     *
     * @param nodeId
     * @return
     */
    List<DictValueDO> listByNodeId(Long nodeId);
}