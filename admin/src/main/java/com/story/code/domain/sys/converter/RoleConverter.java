package com.story.code.domain.sys.converter;

import com.story.code.domain.sys.valueobject.RoleVO;
import com.story.code.infrastructure.tunnel.dataobject.sys.RoleDO;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/28 by Storys.Zhang
 */
@Component
public class RoleConverter {

    public RoleVO doToVo(RoleDO data) {
        RoleVO vo = new RoleVO();
        vo.setId(data.getId());
        vo.setName(data.getName());
        vo.setCode(data.getCode());
        return vo;
    }

}
