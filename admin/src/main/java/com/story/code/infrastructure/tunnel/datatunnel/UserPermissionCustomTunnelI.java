/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.dataobject.sys.UserPermissionCustomDO;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:21:12 by Storys.Zhang
*/
public interface UserPermissionCustomTunnelI{

    /**
    * select object by id
    *
    * @param id
    * @return
    */
    UserPermissionCustomDO get(Long id);

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
    int create(UserPermissionCustomDO record);

    /**
    * update
    *
    * @param record
    * @return
    */
    int update(UserPermissionCustomDO record);
}