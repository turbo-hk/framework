/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.RolePermissionDO;
import com.story.code.infrastructure.tunnel.datatunnel.RolePermissionTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.RolePermissionDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:29 by Storys.Zhang
*/
@Component
public class RolePermissionTunnel implements RolePermissionTunnelI{

    @Resource
    private RolePermissionDAO dao;

    @Override
    public RolePermissionDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(RolePermissionDO record){
        return dao.insert(record);
    }

    @Override
    public int update(RolePermissionDO record){
        return dao.update(record);
    }

}