/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.dataobject.dict.DictNodeDO;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-05-08 15:05:01 by Storys.zhang
*/
public interface DictNodeTunnelI{

    /**
    * select object by id
    *
    * @param id
    * @return
    */
    DictNodeDO get(Long id);

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
    int create(DictNodeDO record);

    /**
    * update
    *
    * @param record
    * @return
    */
    int update(DictNodeDO record);

    /**
     * 查询字典节点
     *
     * @param code
     * @param tenantId
     * @return
     */
    DictNodeDO getByCode(String code, Long tenantId);
}