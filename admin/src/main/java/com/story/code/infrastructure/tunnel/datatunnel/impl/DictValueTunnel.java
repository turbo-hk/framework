/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.dict.DictValueDO;
import com.story.code.infrastructure.tunnel.datatunnel.DictValueTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.dict.DictValueDAO;
import java.util.List;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-05-08 15:05:40 by Storys.zhang
*/
@Component
public class DictValueTunnel implements DictValueTunnelI{

    @Resource
    private DictValueDAO dao;

    @Override
    public DictValueDO get(Long id){
        return dao.get(id);
    }

    @Override
    public int delete(Long id){
        return dao.delete(id);
    }

    @Override
    public int create(DictValueDO record){
        return dao.insert(record);
    }

    @Override
    public int update(DictValueDO record){
        return dao.update(record);
    }

    @Override
    public List<DictValueDO> listByNodeId(Long nodeId) {
        return dao.listByNodeId(nodeId);
    }

}