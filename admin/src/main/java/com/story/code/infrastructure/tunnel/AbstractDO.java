package com.story.code.infrastructure.tunnel;

import lombok.Data;

/**
 * data object 抽象类
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
@Data
public abstract class AbstractDO {

    /**
     * 无符号自增唯一ID
     */
    private Long id;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 数据版本
     */
    private Long version;

    /**
     * 删除标识1：已删除、0：未删除
     */
    private Boolean delFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private java.time.LocalDateTime gmtCreate;

    /**
     * 最后更新时间
     */
    private java.time.LocalDateTime gmtModified;

    /**
     * 修改人
     */
    private String modifiedBy;

}
