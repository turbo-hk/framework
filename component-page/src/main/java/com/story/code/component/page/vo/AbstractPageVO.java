package com.story.code.component.page.vo;

import java.util.List;

/**
 * 分页查询响应结果
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/3/31 by Storys.Zhang
 */
public abstract class AbstractPageVO<T> {

    private Long total;

    private Integer pageSize;

    private Integer current;

    private List<T> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
