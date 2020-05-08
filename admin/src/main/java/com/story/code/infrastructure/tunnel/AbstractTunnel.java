package com.story.code.infrastructure.tunnel;

import static com.story.code.infrastructure.tunnel.common.Constants.DEFAULT_LONG;

import com.story.code.boot.security.SecurityUtils;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
public class AbstractTunnel<T extends AbstractDO, DAO extends AbstractDAO> implements AbstractTunnelI<T> {

    @Autowired
    protected DAO dao;

    @Override
    public Mono<T> get(Long id) {
        return Mono.justOrEmpty((T) dao.get(id));
    }

    @Override
    public Mono<Integer> create(T record) {
        return SecurityUtils.getUserName().map(userName -> {
            record.setCreateBy(userName);
            record.setGmtCreate(LocalDateTime.now());
            record.setDelFlag(Boolean.FALSE);
            record.setVersion(DEFAULT_LONG);
            return dao.insert(record);
        });
    }

    @Override
    public Mono<Integer> update(T record) {
        return SecurityUtils.getUserName().map(userName -> {
            record.setModifiedBy(userName);
            record.setGmtModified(LocalDateTime.now());
            record.setVersion(record.getVersion() + 1);
            return dao.update(record);
        });
    }
}
