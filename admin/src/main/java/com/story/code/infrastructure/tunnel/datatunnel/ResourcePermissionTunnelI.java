/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.dataobject.sys.ResourcePermissionDO;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:14 by Storys.Zhang
*/
public interface ResourcePermissionTunnelI{

    /**
    * select object by id
    *
    * @param id
    * @return
    */
    ResourcePermissionDO get(Long id);

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
    int create(ResourcePermissionDO record);

    /**
    * update
    *
    * @param record
    * @return
    */
    int update(ResourcePermissionDO record);
}