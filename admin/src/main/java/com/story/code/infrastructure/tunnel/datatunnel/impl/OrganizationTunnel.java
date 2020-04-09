/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.OrganizationDO;
import com.story.code.infrastructure.tunnel.datatunnel.OrganizationTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.OrganizationDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:19:52 by Storys.Zhang
*/
@Component
public class OrganizationTunnel implements OrganizationTunnelI{

    @Resource
    private OrganizationDAO dao;

    @Override
    public OrganizationDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(OrganizationDO record){
        return dao.insert(record);
    }

    @Override
    public int update(OrganizationDO record){
        return dao.update(record);
    }

}