package com.story.code.common.converter;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
public interface DataObjectToValueObject<D, V> {

    /**
     * 数据库对象转换为值对象
     *
     * @param data
     * @return
     */
    V doToVo(D data);

}
