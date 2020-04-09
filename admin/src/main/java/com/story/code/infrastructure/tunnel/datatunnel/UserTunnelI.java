/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:36 by Storys.Zhang
*/
public interface UserTunnelI{

    /**
    * select object by id
    *
    * @param id
    * @return
    */
    UserDO get(Long id);

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
    int create(UserDO record);

    /**
    * update
    *
    * @param record
    * @return
    */
    int update(UserDO record);
}