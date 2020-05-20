package com.story.code.common.converter;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/19 by Storys.Zhang
 */
public interface RequestQueryToDTO<Q, DTO> {

    /**
     * app层请求参数转换为数据层的请求参数
     *
     * @param command
     * @return
     */
    DTO toDto(Q command);
}
