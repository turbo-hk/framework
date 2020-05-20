package com.story.code.app.sys.handler;

import static com.story.code.common.ApiResponseVO.defaultSuccessful;

import com.story.code.app.sys.command.RolePersistCommand;
import com.story.code.app.sys.converter.RoleAppConverter;
import com.story.code.app.sys.query.RolePageListQuery;
import com.story.code.app.sys.validator.RolePersistValidator;
import com.story.code.app.sys.vo.RolePageListVO;
import com.story.code.boot.security.SecurityUtils;
import com.story.code.boot.security.TenantIdUtil;
import com.story.code.boot.security.TokenProvider.TokenLoginUser;
import com.story.code.common.ApiResponseVO;
import com.story.code.component.page.PageComponent;
import com.story.code.component.page.vo.PageVO;
import com.story.code.component.saveorupdate.DataPersistComponent;
import com.story.code.infrastructure.tunnel.dataobject.sys.RoleDO;
import com.story.code.infrastructure.tunnel.datatunnel.RoleTunnelI;
import com.story.code.infrastructure.tunnel.param.sys.RolePageListParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 角色
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@Component
public class RoleHandler {

    @Autowired
    private RoleAppConverter roleAppConverter;
    @Autowired
    private RoleTunnelI roleTunnel;
    @Autowired
    private RolePersistValidator rolePersistValidator;

    public Mono<ServerResponse> page(ServerRequest request) {
        return request.bodyToMono(RolePageListQuery.class).map(query -> {
            PageComponent<RolePageListParam, RoleDO, RolePageListVO> component = new PageComponent<>(
                roleAppConverter.toParam(query), query.getPage());
            component.buildDataListFunction(roleTunnel::pageList);
            component.buildConvertVoFunction(roleAppConverter::doToVo);
            return component.page();
        }).flatMap(page -> ServerResponse.ok().bodyValue(ApiResponseVO.<PageVO<RolePageListVO>>create().data(page).buildSuccess()));
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        TokenLoginUser loginUser = SecurityUtils.getLoginUser(request.exchange().getRequest());
        return request.bodyToMono(RolePersistCommand.class).map(command -> {
            DataPersistComponent<RolePersistCommand, RoleDO> component = new DataPersistComponent(command, command.getId());
            component.addValidatorFunction(rolePersistValidator::validate);
            component.addCreatePersistStrategyFunction(() -> {
                RoleDO data = new RoleDO();
                data.setName(command.getName());
                data.setTenantId(TenantIdUtil.getTenantId());
                data.setParentId(command.getParentId());
                return roleTunnel.create(data, loginUser.getUserName());
            });
            component.addUpdatePersistStrategyFunction(() -> {
                RoleDO data = roleTunnel.get(command.getId());
                data.setParentId(command.getParentId());
                data.setName(command.getName());
                return roleTunnel.update(data, loginUser.getUserName());
            });
            return component.persist();

        }).flatMap(count -> ServerResponse.ok().bodyValue(defaultSuccessful()));
    }
}
