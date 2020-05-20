package com.story.code.component.page;

import java.util.List;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@FunctionalInterface
public interface DataListFunction<P, T> {

    /**
     * 分页数据
     *
     * @param param
     * @return
     */
    List<T> pageList(P param);

}
