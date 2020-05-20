package com.story.code.app.sys.converter;

import com.story.code.app.sys.query.GroupPageListQuery;
import com.story.code.app.sys.vo.GroupPageListVO;
import com.story.code.common.converter.DataObjectToValueObject;
import com.story.code.common.converter.RequestQueryToDatabaseParam;
import com.story.code.infrastructure.tunnel.dataobject.sys.GroupDO;
import com.story.code.infrastructure.tunnel.param.sys.GroupPageListParam;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@Component
public class GroupAppConverter implements RequestQueryToDatabaseParam<GroupPageListQuery, GroupPageListParam>, DataObjectToValueObject<GroupDO, GroupPageListVO> {

    @Override
    public GroupPageListVO doToVo(GroupDO data) {
        GroupPageListVO vo = new GroupPageListVO();
        vo.setId(data.getId());
        vo.setParentId(data.getParentId());
        vo.setName(data.getName());
        return vo;
    }

    @Override
    public GroupPageListParam toParam(GroupPageListQuery query) {
        GroupPageListParam param = new GroupPageListParam();
        param.setParentId(query.getParentId());
        return param;
    }
}
