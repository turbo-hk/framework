/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.UserRoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserRoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.UserRoleDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:21:17 by Storys.Zhang
*/
@Component
public class UserRoleTunnel implements UserRoleTunnelI{

    @Resource
    private UserRoleDAO dao;

    @Override
    public UserRoleDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(UserRoleDO record){
        return dao.insert(record);
    }

    @Override
    public int update(UserRoleDO record){
        return dao.update(record);
    }

}