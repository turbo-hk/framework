package com.story.code.infrastructure.tunnel.param.sys;

import com.story.code.infrastructure.tunnel.AbstractParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RolePageListParam extends AbstractParam {

    private Long parentId;

}
