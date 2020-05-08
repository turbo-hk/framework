package com.story.code.common.converter;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
public interface RequestQueryToDatabaseParam<Q, P> {

    /**
     * app层请求参数转换为db层的请求参数
     *
     * @param query
     * @return
     */
    P toParam(Q query);

}
