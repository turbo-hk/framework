/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.story.code.infrastructure.tunnel.dataobject.dict.DictNodeDO;
import com.story.code.infrastructure.tunnel.datatunnel.DictNodeTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.dict.DictNodeDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-05-08 15:05:01 by Storys.zhang
 */
@Component
public class DictNodeTunnel implements DictNodeTunnelI {

    @Resource
    private DictNodeDAO dao;

    @Override
    public DictNodeDO get(Long id) {
        return dao.get(id);
    }

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public int create(DictNodeDO record) {
        return dao.insert(record);
    }

    @Override
    public int update(DictNodeDO record) {
        return dao.update(record);
    }

    @Override
    public DictNodeDO getByCode(String code, Long tenantId) {
        return dao.getByCode(code, tenantId);
    }

}