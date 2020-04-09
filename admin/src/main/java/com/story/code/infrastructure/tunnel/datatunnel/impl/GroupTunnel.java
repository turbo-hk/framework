/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.GroupDO;
import com.story.code.infrastructure.tunnel.datatunnel.GroupTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.GroupDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:19:00 by Storys.Zhang
*/
@Component
public class GroupTunnel implements GroupTunnelI{

    @Resource
    private GroupDAO dao;

    @Override
    public GroupDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(GroupDO record){
        return dao.insert(record);
    }

    @Override
    public int update(GroupDO record){
        return dao.update(record);
    }

}