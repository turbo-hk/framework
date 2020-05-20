package com.story.code.infrastructure.tunnel;

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
    T get(Long id);

    /**
     * create
     *
     * @param record
     * @param loginUser
     * @return
     */
    int create(T record, String loginUser);

    /**
     * update
     *
     * @param record
     * @param loginUser
     * @return
     */
    int update(T record, String loginUser);
}
