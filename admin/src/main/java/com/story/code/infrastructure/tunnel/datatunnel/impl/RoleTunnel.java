/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.RoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.RoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.RoleDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:24 by Storys.Zhang
*/
@Component
public class RoleTunnel implements RoleTunnelI{

    @Resource
    private RoleDAO dao;

    @Override
    public RoleDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(RoleDO record){
        return dao.insert(record);
    }

    @Override
    public int update(RoleDO record){
        return dao.update(record);
    }

}