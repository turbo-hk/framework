package com.story.code.infrastructure.tunnel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据权限实体
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/6 by Storys.Zhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AbstractDataScopeDO extends AbstractDO {

    /**
     * 数据权限用户id
     */
    private Long dataScopeUserId;
}
