/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.ResourcePageElementDO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourcePageElementTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.ResourcePageElementDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:08 by Storys.Zhang
*/
@Component
public class ResourcePageElementTunnel implements ResourcePageElementTunnelI{

    @Resource
    private ResourcePageElementDAO dao;

    @Override
    public ResourcePageElementDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(ResourcePageElementDO record){
        return dao.insert(record);
    }

    @Override
    public int update(ResourcePageElementDO record){
        return dao.update(record);
    }

}