package com.story.code.common.page.reactive;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.story.code.common.page.PageDataConverter;
import com.story.code.common.page.PageWrapper;
import com.story.code.component.page.query.PageQuery;
import com.story.code.component.page.vo.PageVO;
import lombok.Setter;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/13 by Storys.Zhang
 */
public class PageReactiveWrapper<D, V, Q> {

    public static <D, V, Q> Mono<PageVO<V>> page(PageReactiveDataListFunction<D, Q> dataList, PageDataConverter<D, V> converter, PageQuery pageQuery, Q query) {
        Preconditions.checkNotNull(dataList);
        Preconditions.checkNotNull(converter);
        Preconditions.checkNotNull(pageQuery);
        Preconditions.checkNotNull(query);
        DefaultPageReactiveDataListToPageFunctionFunction<D, V, Q> function = new DefaultPageReactiveDataListToPageFunctionFunction<>();
        function.setDataList(dataList);
        function.setConverter(converter);
        function.setPageQuery(pageQuery);
        function.setQuery(query);
        return function.thenToPage();
    }

    private final static class DefaultPageReactiveDataListToPageFunctionFunction<D, V, Q> implements PageReactiveDataListToPageFunction<D, V, Q> {

        @Setter
        private PageReactiveDataListFunction<D, Q> dataList;
        @Setter
        private PageDataConverter<D, V> converter;
        @Setter
        private PageQuery pageQuery;
        @Setter
        private Q query;

        @Override
        public Mono<PageVO<V>> thenToPage() {
            PageHelper.startPage(pageQuery.getCurrent(), pageQuery.getPageSize());
            return dataList.dataList(query).map(dataList -> PageWrapper.page(dataList, pageQuery, converter));
        }
    }

}
