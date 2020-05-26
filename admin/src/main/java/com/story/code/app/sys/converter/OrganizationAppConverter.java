package com.story.code.app.sys.converter;

import com.story.code.app.sys.query.OrganizationPageListQuery;
import com.story.code.app.sys.vo.OrganizationPageListVO;
import com.story.code.common.converter.DataObjectToValueObject;
import com.story.code.common.converter.RequestQueryToDatabaseParam;
import com.story.code.infrastructure.tunnel.dataobject.sys.OrganizationDO;
import com.story.code.infrastructure.tunnel.param.sys.OrganizationPageListParam;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/25 by Storys.Zhang
 */
@Component
public class OrganizationAppConverter implements RequestQueryToDatabaseParam<OrganizationPageListQuery, OrganizationPageListParam>,
    DataObjectToValueObject<OrganizationDO, OrganizationPageListVO> {

    @Override
    public OrganizationPageListVO doToVo(OrganizationDO data) {
        OrganizationPageListVO vo = new OrganizationPageListVO();
        vo.setId(data.getId());
        vo.setParentId(data.getParentId());
        vo.setName(data.getName());
        return vo;
    }

    @Override
    public OrganizationPageListParam toParam(OrganizationPageListQuery query) {
        OrganizationPageListParam param = new OrganizationPageListParam();
        param.setParentId(query.getParentId());
        return param;
    }
}
