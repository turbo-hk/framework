package com.story.code.component.page.query;

/**
 * 分页查询请求参数
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/3/31 by Storys.Zhang
 */
public abstract class AbstractPageQuery {

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 每页条数
     */
    private Integer pageSize;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
