/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel;

import com.story.code.infrastructure.tunnel.dataobject.sys.GroupDO;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:19:00 by Storys.Zhang
*/
public interface GroupTunnelI{

    /**
    * select object by id
    *
    * @param id
    * @return
    */
    GroupDO get(Long id);

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
    int create(GroupDO record);

    /**
    * update
    *
    * @param record
    * @return
    */
    int update(GroupDO record);
}