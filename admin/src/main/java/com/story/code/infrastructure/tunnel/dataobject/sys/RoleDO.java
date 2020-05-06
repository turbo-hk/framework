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
 * Created at 2020-03-26 16:20:24 by Storys.Zhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleDO extends AbstractDO {

    /**
     * 数据权限
     */
    private Integer dataScope;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 父角色ID
     */
    private Long parentId;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 角色代码， 不支持中文
     */
    private String code;

}