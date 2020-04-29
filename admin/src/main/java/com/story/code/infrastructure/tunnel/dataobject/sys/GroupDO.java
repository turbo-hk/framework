/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.dataobject.sys;

import com.story.code.infrastructure.tunnel.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:19:00 by Storys.Zhang
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class GroupDO extends AbstractDO {

    /**  */
    private String name;

    /** 父ID */
    private Long parentId;

    /** 租户ID */
    private Long tenantId;
}