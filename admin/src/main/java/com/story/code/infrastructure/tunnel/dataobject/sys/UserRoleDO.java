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
 * Created at 2020-03-26 16:21:17 by Storys.Zhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRoleDO extends AbstractDO {

    /**
     *
     */
    private Long roleId;

    /**
     *
     */
    private Long userId;
}