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
* Created at 2020-03-26 16:20:19 by Storys.Zhang
*/
@Data
public class ResourceTypeDO  extends AbstractDO {

    /** 租户ID */
    private Long tenantId;

    /**  */
    private String title;

    /**  */
    private String type;

}