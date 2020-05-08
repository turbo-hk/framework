package com.story.code.app.sys.converter;

import com.story.code.app.sys.query.MenuPageListQuery;
import com.story.code.app.sys.vo.MenuPageListVO;
import com.story.code.common.converter.DataObjectToValueObject;
import com.story.code.common.converter.RequestQueryToDatabaseParam;
import com.story.code.helper.BeanMapperHelper;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import com.story.code.infrastructure.tunnel.param.sys.MenuPageListParam;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
@Component
public class MenuAppConverter implements RequestQueryToDatabaseParam<MenuPageListQuery, MenuPageListParam>,
    DataObjectToValueObject<ResourceMenuDO, MenuPageListVO> {

    @Override
    public MenuPageListParam toParam(MenuPageListQuery query) {
        MenuPageListParam param = new MenuPageListParam();
        BeanMapperHelper.copy(query, param);
        return param;
    }

    @Override
    public MenuPageListVO doToVo(ResourceMenuDO data) {
        MenuPageListVO vo = new MenuPageListVO();
        BeanMapperHelper.copy(data, vo);
        return vo;
    }


}
