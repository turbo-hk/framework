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
* Created at 2020-03-26 16:20:08 by Storys.Zhang
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourcePageElementDO  extends AbstractDO {

    /** 页面元素编码 */
    private String code;

    /** 租户ID */
    private Long tenantId;

}