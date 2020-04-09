/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.UserPermissionCustomDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserPermissionCustomTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.UserPermissionCustomDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:21:12 by Storys.Zhang
*/
@Component
public class UserPermissionCustomTunnel implements UserPermissionCustomTunnelI{

    @Resource
    private UserPermissionCustomDAO dao;

    @Override
    public UserPermissionCustomDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(UserPermissionCustomDO record){
        return dao.insert(record);
    }

    @Override
    public int update(UserPermissionCustomDO record){
        return dao.update(record);
    }

}