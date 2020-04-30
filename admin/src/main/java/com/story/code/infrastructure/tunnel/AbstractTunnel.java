package com.story.code.infrastructure.tunnel;

import static com.story.code.infrastructure.tunnel.common.Constants.DEFAULT_LONG;

import java.time.LocalDateTime;
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
        record.setCreateBy("0");
        record.setGmtCreate(LocalDateTime.now());
        record.setDelFlag(Boolean.FALSE);
        record.setVersion(DEFAULT_LONG);
        return dao.insert(record);
    }

    @Override
    public int update(T record) {
        return dao.update(record);
    }
}
