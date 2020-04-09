/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.ResourcePermissionDO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourcePermissionTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.ResourcePermissionDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:14 by Storys.Zhang
*/
@Component
public class ResourcePermissionTunnel implements ResourcePermissionTunnelI{

    @Resource
    private ResourcePermissionDAO dao;

    @Override
    public ResourcePermissionDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(ResourcePermissionDO record){
        return dao.insert(record);
    }

    @Override
    public int update(ResourcePermissionDO record){
        return dao.update(record);
    }

}