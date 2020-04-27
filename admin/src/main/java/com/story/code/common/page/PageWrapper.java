package com.story.code.common.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.story.code.component.page.query.PageQuery;
import com.story.code.component.page.vo.PageVO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/13 by Storys.Zhang
 */
@FunctionalInterface
public interface PageWrapper<D, V, Q> {

    /**
     * 分页数据
     *
     * @param query
     * @return
     */
    List<D> dataList(Q query);

    /**
     * 分页
     *
     * @param query
     * @param pageQuery
     * @return
     */
    default PageVO page(Q query, PageQuery pageQuery, PageDataConverter<D, V> converter) {
        PageHelper.startPage(pageQuery.getCurrent(), pageQuery.getPageSize());
        List<D> dataList = this.dataList(query);
        PageInfo<D> pageInfo = new PageInfo<>(dataList);
        List<V> list = pageInfo.getList().stream().map(f -> converter.convert(f)).collect(Collectors.toList());
        PageVO pageVO = new PageVO();
        pageVO.setCurrent(pageInfo.getPageNum());
        pageVO.setPageSize(pageInfo.getPageSize());
        pageVO.setTotal(pageInfo.getTotal());
        pageVO.setData(list);
        return pageVO;
    }
}
