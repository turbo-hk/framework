/**
* Copyright (c) 2019, Credan(上海)-版权所有
*/
package com.story.code.infrastructure.tunnel.dataobject.dict;

import lombok.Data;


/**
*
*
* @author storys.zhang@gmail.com
*
* Created at 2020-05-08 15:05:40 by Storys.zhang
*/
@Data
public class DictValueDO{

    /** 键 */
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

    /** 节点ID */
    private Long nodeId;

    /** 排序字段（越大越靠前） */
    private Integer rankNum;

    /** 备注 */
    private String remarks;

    /** 值 */
    private String value;

    /** 数据版本 */
    private Long version;

}