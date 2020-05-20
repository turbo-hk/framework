package com.story.code.app.sys.handler;

import static com.story.code.common.ApiResponseVO.defaultSuccessful;

import com.story.code.app.sys.command.MenuPersistCommand;
import com.story.code.app.sys.converter.MenuAppConverter;
import com.story.code.app.sys.query.MenuPageListQuery;
import com.story.code.app.sys.validator.MenuPersistValidator;
import com.story.code.app.sys.vo.MenuPageListVO;
import com.story.code.boot.security.SecurityUtils;
import com.story.code.boot.security.TenantIdUtil;
import com.story.code.boot.security.TokenProvider.TokenLoginUser;
import com.story.code.common.ApiResponseVO;
import com.story.code.component.page.PageComponent;
import com.story.code.component.page.vo.PageVO;
import com.story.code.component.saveorupdate.DataPersistComponent;
import com.story.code.domain.sys.factory.UserAuthorityFactory;
import com.story.code.domain.sys.valueobject.MenuTreeNode;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourceMenuTunnelI;
import com.story.code.infrastructure.tunnel.param.sys.MenuPageListParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/7 by Storys.Zhang
 */
@Component
public class MenuHandler {

    @Autowired
    private ResourceMenuTunnelI resourceMenuTunnel;
    @Autowired
    private MenuAppConverter menuAppConverter;
    @Autowired
    private UserAuthorityFactory userAuthorityFactory;
    @Autowired
    private MenuPersistValidator menuPersistValidator;


    public Mono<ServerResponse> authority(ServerRequest request) {
        return SecurityUtils.getLoginUser().map(loginUser -> userAuthorityFactory.userAuthorityAggregation(loginUser.getLoginUserId()).getMenuTreeNodeList())
            .flatMap(data -> ServerResponse.ok().bodyValue(ApiResponseVO.<List<MenuTreeNode>>create().data(data).buildSuccess()));
    }

    public Mono<ServerResponse> page(ServerRequest request) {

        return request.bodyToMono(MenuPageListQuery.class).map(query -> {
            PageComponent<MenuPageListParam, ResourceMenuDO, MenuPageListVO> component = new PageComponent(query, query.getPage());
            component.buildDataListFunction(resourceMenuTunnel::pageList);
            component.buildConvertVoFunction(menuAppConverter::doToVo);
            return component.page();
        }).flatMap(page -> ServerResponse.ok().bodyValue(ApiResponseVO.<PageVO<MenuPageListVO>>create().data(page).buildSuccess()));
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        TokenLoginUser loginUser = SecurityUtils.getLoginUser(request.exchange().getRequest());
        return request.bodyToMono(MenuPersistCommand.class).map(command -> {
            DataPersistComponent<MenuPersistCommand, ResourceMenuDO> component = new DataPersistComponent(command, command.getId());
            component.addValidatorFunction(menuPersistValidator::validate);
            component.addCreatePersistStrategyFunction(() -> {
                ResourceMenuDO data = new ResourceMenuDO();
                data.setTenantId(TenantIdUtil.getTenantId());
                data.setParentId(command.getParentId());
                data.setRankNum(command.getRankNum());
                data.setTitle(command.getTitle());
                data.setUrl(command.getUrl());
                data.setIcon(command.getIcon());
                return resourceMenuTunnel.create(data, loginUser.getUserName());
            });
            component.addUpdatePersistStrategyFunction(() -> {
                ResourceMenuDO data = resourceMenuTunnel.get(command.getId());
                data.setParentId(command.getParentId());
                data.setRankNum(command.getRankNum());
                data.setTitle(command.getTitle());
                data.setUrl(command.getUrl());
                data.setIcon(command.getIcon());
                return resourceMenuTunnel.update(data, loginUser.getUserName());
            });
            return component.persist();
        })
            .flatMap(count -> ServerResponse.ok().bodyValue(defaultSuccessful()));
    }


}
