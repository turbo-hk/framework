package com.story.code.infrastructure.tunnel;

import org.apache.ibatis.annotations.Param;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
public interface AbstractDAO<T extends AbstractDO> {
    /**
     * select object by id
     *
     * @param id
     * @return
     */
    T get(@Param("id") Long id);

    /**
     * insert
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * update
     *
     * @param record
     * @return
     */
    int update(T record);
}
