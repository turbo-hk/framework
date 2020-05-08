/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.dataobject.sys;

import com.story.code.infrastructure.tunnel.AbstractDataScopeDO;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:36 by Storys.Zhang
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDO extends AbstractDataScopeDO {

    /**  */
    private String loginName;

    /**  */
    private String mobile;

    /** 组织机构ID */
    private Long organizationId;

    /**  */
    private String password;

    /**  */
    private String salt;

    /**  */
    private String tel;

    /** 租户ID */
    private Long tenantId;

    /**
     * 1：禁用、0：启用
     */
    private Boolean disabled;

}