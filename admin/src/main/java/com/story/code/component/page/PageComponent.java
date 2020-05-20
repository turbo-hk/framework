package com.story.code.component.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.story.code.component.page.query.PageQuery;
import com.story.code.component.page.vo.PageVO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
public class PageComponent<P, T, V> {

    private P param;

    private PageQuery pageQuery;


    private DataListFunction<P, T> dataListFunction;


    private ConvertVoFunction<T, V> convertVoFunction;

    public PageComponent(P param, PageQuery pageQuery) {
        this.param = param;
        this.pageQuery = pageQuery;
    }

    public PageComponent buildDataListFunction(DataListFunction<P, T> function) {
        this.dataListFunction = function;
        return this;
    }

    public PageComponent buildConvertVoFunction(ConvertVoFunction<T, V> function) {
        this.convertVoFunction = function;
        return this;
    }

    public PageVO<V> page() {
        PageHelper.startPage(pageQuery.getCurrent(), pageQuery.getPageSize());
        List<T> dataList = dataListFunction.pageList(this.param);
        PageInfo<T> pageInfo = new PageInfo<>(dataList);
        List<V> list = pageInfo.getList().stream().map(f -> convertVoFunction.convert(f)).collect(Collectors.toList());
        PageVO pageVO = new PageVO();
        pageVO.setCurrent(pageInfo.getPageNum());
        pageVO.setPageSize(pageInfo.getPageSize());
        pageVO.setTotal(pageInfo.getTotal());
        pageVO.setData(list);
        return pageVO;
    }
}
