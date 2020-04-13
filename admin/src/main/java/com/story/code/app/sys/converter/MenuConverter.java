package com.story.code.app.sys.converter;

import com.story.code.app.sys.vo.MenuPageListVO;
import com.story.code.helper.BeanMapperHelper;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import com.story.code.infrastructure.tunnel.query.sys.MenuPageListQuery;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/8 by Storys.Zhang
 */
@Component
public class MenuConverter {

    public MenuPageListQuery toParam(com.story.code.app.sys.query.MenuPageListQuery query) {
        MenuPageListQuery param = new MenuPageListQuery();
        BeanMapperHelper.copy(query, param);
        return param;
    }

    public MenuPageListVO doToVo(ResourceMenuDO data){
        MenuPageListVO vo = new MenuPageListVO();
        vo.setName(data.getTitle());
        return vo;
    }

}
