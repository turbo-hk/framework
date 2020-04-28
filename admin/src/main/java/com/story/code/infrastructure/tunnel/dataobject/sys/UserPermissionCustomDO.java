/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.dataobject.sys;

import com.story.code.infrastructure.tunnel.AbstractDO;
import lombok.Data;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:21:12 by Storys.Zhang
*/
@Data
public class UserPermissionCustomDO  extends AbstractDO {

    /**  */
    private Long permissionId;

    /** 租户ID */
    private Long tenantId;

    /**  */
    private Long userId;


}