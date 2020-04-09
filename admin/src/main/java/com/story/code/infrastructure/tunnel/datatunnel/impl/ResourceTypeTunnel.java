/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceTypeDO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourceTypeTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.ResourceTypeDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:19 by Storys.Zhang
*/
@Component
public class ResourceTypeTunnel implements ResourceTypeTunnelI{

    @Resource
    private ResourceTypeDAO dao;

    @Override
    public ResourceTypeDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(ResourceTypeDO record){
        return dao.insert(record);
    }

    @Override
    public int update(ResourceTypeDO record){
        return dao.update(record);
    }

}