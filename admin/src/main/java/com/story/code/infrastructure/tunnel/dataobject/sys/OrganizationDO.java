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
 * Created at 2020-03-26 16:19:52 by Storys.Zhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrganizationDO extends AbstractDO {

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 带有上下级格式的id
     */
    private String uid;

    /**
     * 带有上下级格式的id的父ID
     */
    private String parentUid;


    /**
     * 名称
     */
    private String name;

    /**
     * 租户ID
     */
    private Long tenantId;


}