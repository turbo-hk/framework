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
* Created at 2020-03-26 16:20:14 by Storys.Zhang
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourcePermissionDO  extends AbstractDO {

    /**  */
    private Long resourceId;

    /**  */
    private Long resourceTypeId;

}