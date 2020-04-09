/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.dataobject.sys;

import lombok.Data;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-03-26 16:20:08 by Storys.Zhang
*/
@Data
public class ResourcePageElementDO{

    /** 页面元素编码 */
    private String code;

    /** 创建人 */
    private String createBy;

    /** 删除标识1：已删除、0：未删除 */
    private Boolean delFlag;

    /** 创建时间 */
    private java.time.LocalDateTime gmtCreate;

    /** 最后更新时间 */
    private java.time.LocalDateTime gmtModified;

    /** 无符号自增唯一ID */
    private Long id;

    /** 修改人 */
    private String modifiedBy;

    /** 备注 */
    private String remarks;

    /** 租户ID */
    private Long tenantId;

    /** 数据版本 */
    private Long version;

}