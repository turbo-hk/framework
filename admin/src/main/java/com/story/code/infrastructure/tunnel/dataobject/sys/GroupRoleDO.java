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
* Created at 2020-03-26 16:19:40 by Storys.Zhang
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class GroupRoleDO extends AbstractDO {

    /**  */
    private Long groupId;

    /**  */
    private Long roleId;

}