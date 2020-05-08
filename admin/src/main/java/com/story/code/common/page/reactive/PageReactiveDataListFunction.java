package com.story.code.common.page.reactive;

import java.util.List;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/7 by Storys.Zhang
 */
@FunctionalInterface
public interface PageReactiveDataListFunction<D, Q> {

    /**
     * 查询数据库数据
     *
     * @param query
     * @return
     */
    Mono<List<D>> dataList(Q query);

}
