package com.story.code.common.page.reactive;

import com.story.code.component.page.vo.PageVO;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/7 by Storys.Zhang
 */
@FunctionalInterface
public interface PageReactiveDataListToPageFunction<D, V, Q> {

    /**
     * 转换成page对象
     *
     * @return
     */
    Mono<PageVO<V>> thenToPage();

}
