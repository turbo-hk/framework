package com.story.code.infrastructure.tunnel;

import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
public interface AbstractTunnelI<T extends AbstractDO> {

    /**
     * select object by id
     *
     * @param id
     * @return
     */
    Mono<T> get(Long id);

    /**
     * create
     *
     * @param record
     * @return
     */
    Mono<Integer> create(T record);

    /**
     * update
     *
     * @param record
     * @return
     */
    Mono<Integer> update(T record);
}
