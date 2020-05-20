package com.story.code.app.sys.converter;

import com.story.code.app.sys.query.RolePageListQuery;
import com.story.code.app.sys.vo.RolePageListVO;
import com.story.code.common.converter.DataObjectToValueObject;
import com.story.code.common.converter.RequestQueryToDatabaseParam;
import com.story.code.infrastructure.tunnel.dataobject.sys.RoleDO;
import com.story.code.infrastructure.tunnel.param.sys.RolePageListParam;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@Component
public class RoleAppConverter implements RequestQueryToDatabaseParam<RolePageListQuery, RolePageListParam>, DataObjectToValueObject<RoleDO, RolePageListVO> {

    @Override
    public RolePageListVO doToVo(RoleDO data) {
        RolePageListVO vo = new RolePageListVO();
        vo.setId(data.getId());
        vo.setParentId(data.getParentId());
        vo.setName(data.getName());
        return vo;
    }

    @Override
    public RolePageListParam toParam(RolePageListQuery query) {
        RolePageListParam param = new RolePageListParam();
        param.setParentId(query.getParentId());
        return param;
    }
}
