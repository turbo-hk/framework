/**
 * Copyright (c) 2019, Credan(上海)-版权所有
 */
package com.story.code.infrastructure.tunnel.dataobject.sys;

import com.story.code.infrastructure.tunnel.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020-03-26 16:20:00 by Storys.Zhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceMenuDO extends AbstractDO {

    /**
     *
     */
    private Long parentId;

    /**
     * 排序
     */
    private Long rankNum;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     *
     */
    private String title;

    /**
     *
     */
    private String url;


}