/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.datatunnel.impl;

import com.google.common.collect.Lists;
import com.story.code.helper.CollectionHelper;
import com.story.code.infrastructure.tunnel.AbstractTunnel;
import com.story.code.infrastructure.tunnel.dataobject.sys.RoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.RoleTunnelI;
import com.story.code.infrastructure.tunnel.datatunnel.database.sys.RoleDAO;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:24 by Storys.Zhang
 */
@Component
public class RoleTunnel extends AbstractTunnel<RoleDO, RoleDAO> implements RoleTunnelI {


    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<RoleDO> listByIds(List<Long> ids) {
        if (CollectionHelper.isEmpty(ids)) {
            return CollectionHelper.EMPTY;
        }
        return dao.listByIds(ids);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleDO> listChildren(Long parentId) {
        List<RoleDO> flatList = Lists.newArrayList();
        List<RoleDO> children = dao.listByParentId(parentId);
        getChildren(children, flatList);
        return flatList;
    }

    private void getChildren(List<RoleDO> children, List<RoleDO> flatList) {
        children.stream().forEach(roleDO -> {
            flatList.add(roleDO);
            List<RoleDO> roleDOS = dao.listByParentId(roleDO.getId());
            if (roleDOS.size() == 0) {
                return;
            }
            getChildren(roleDOS, flatList);
            flatList.addAll(roleDOS);
        });
    }

}