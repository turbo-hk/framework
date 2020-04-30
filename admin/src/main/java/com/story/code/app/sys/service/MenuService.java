package com.story.code.app.sys.service;

import static com.story.code.common.ApiResponseVO.defaultSuccessful;

import com.story.code.app.sys.command.MenuPersistCommand;
import com.story.code.app.sys.converter.MenuAppConverter;
import com.story.code.app.sys.query.MenuPageListQuery;
import com.story.code.app.sys.vo.MenuPageListVO;
import com.story.code.common.ApiResponseVO;
import com.story.code.common.DefaultVO;
import com.story.code.common.page.PageWrapper;
import com.story.code.component.page.vo.PageVO;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourceMenuTunnelI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/3/31 by Storys.Zhang
 */
@Service
public class MenuService {

    @Autowired
    private ResourceMenuTunnelI resourceMenuTunnel;
    @Autowired
    private MenuAppConverter menuConverter;

    public ApiResponseVO<PageVO<MenuPageListVO>> page(MenuPageListQuery query) {
        PageWrapper<ResourceMenuDO, MenuPageListVO, MenuPageListQuery> pageWrapper = query1 -> resourceMenuTunnel.pageList(menuConverter.toParam(query1));
        PageVO page = pageWrapper.page(query, query.getPage(), data -> menuConverter.doToVo(data));
        return ApiResponseVO.<PageVO<MenuPageListVO>>create().data(page).buildSuccess();
    }

    public ApiResponseVO<DefaultVO> add(MenuPersistCommand command) {
        return defaultSuccessful();
    }

    public ApiResponseVO<DefaultVO> update(MenuPersistCommand command) {
        return defaultSuccessful();
    }
}
