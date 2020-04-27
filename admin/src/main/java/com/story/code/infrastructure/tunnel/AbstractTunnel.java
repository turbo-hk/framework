package com.story.code.infrastructure.tunnel;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
public class AbstractTunnel<T extends AbstractDO, DAO extends AbstractDAO> implements AbstractTunnelI<T> {

    @Autowired
    protected DAO dao;

    @Override
    public T get(Long id) {
        return (T) dao.get(id);
    }

    @Override
    public int create(T record) {
        return dao.insert(record);
    }

    @Override
    public int update(T record) {
        return dao.update(record);
    }
}
