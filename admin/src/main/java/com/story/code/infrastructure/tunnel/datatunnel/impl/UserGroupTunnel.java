/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.UserGroupDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserGroupTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.UserGroupDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:41 by Storys.Zhang
*/
@Component
public class UserGroupTunnel implements UserGroupTunnelI{

    @Resource
    private UserGroupDAO dao;

    @Override
    public UserGroupDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(UserGroupDO record){
        return dao.insert(record);
    }

    @Override
    public int update(UserGroupDO record){
        return dao.update(record);
    }

}