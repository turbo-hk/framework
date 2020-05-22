package com.story.code.app.sys.handler;

import static com.story.code.common.ApiResponseVO.defaultSuccessful;

import com.story.code.app.sys.command.GroupPersistCommand;
import com.story.code.app.sys.converter.GroupAppConverter;
import com.story.code.app.sys.query.GroupPageListQuery;
import com.story.code.app.sys.validator.GroupPersistValidator;
import com.story.code.app.sys.vo.GroupPageListVO;
import com.story.code.boot.security.SecurityUtils;
import com.story.code.boot.security.TenantIdUtil;
import com.story.code.boot.security.TokenProvider.TokenLoginUser;
import com.story.code.common.ApiResponseVO;
import com.story.code.component.page.PageComponent;
import com.story.code.component.page.vo.PageVO;
import com.story.code.component.saveorupdate.DataPersistComponent;
import com.story.code.component.saveorupdate.ValidatorFunction;
import com.story.code.infrastructure.tunnel.dataobject.sys.GroupDO;
import com.story.code.infrastructure.tunnel.datatunnel.GroupTunnelI;
import com.story.code.infrastructure.tunnel.param.sys.GroupPageListParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 用户组
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/20 by Storys.Zhang
 */
@Component
public class GroupHandler {

    @Autowired
    private GroupAppConverter groupAppConverter;
    @Autowired
    private GroupTunnelI groupTunnel;
    @Autowired
    private GroupPersistValidator groupPersistValidator;

    public Mono<ServerResponse> page(ServerRequest request) {
        return request.bodyToMono(GroupPageListQuery.class).map(query -> {
            PageComponent<GroupPageListParam, GroupDO, GroupPageListVO> component = new PageComponent<GroupPageListParam, GroupDO, GroupPageListVO>(
                groupAppConverter.toParam(query), query.getPage());
            component.buildDataListFunction(groupTunnel::pageList);
            component.buildConvertVoFunction(groupAppConverter::doToVo);
            return component.page();
        }).flatMap(page -> ServerResponse.ok().bodyValue(ApiResponseVO.<PageVO<GroupPageListVO>>create().data(page).buildSuccess()));
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        return persist(request, groupPersistValidator::validateAdd);
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return persist(request, groupPersistValidator::validateUpdate);
    }

    private Mono<ServerResponse> persist(ServerRequest request, ValidatorFunction<GroupPersistCommand> validatorFunction) {
        TokenLoginUser loginUser = SecurityUtils.getLoginUser(request.exchange().getRequest());
        return request.bodyToMono(GroupPersistCommand.class).map(command -> {
            DataPersistComponent<GroupPersistCommand, GroupDO> component = new DataPersistComponent(command, command.getId());
            component.addValidatorFunction(validatorFunction);
            component.addCreatePersistStrategyFunction(() -> {
                GroupDO data = new GroupDO();
                data.setName(command.getName());
                data.setTenantId(TenantIdUtil.getTenantId());
                data.setParentId(command.getParentId());
                return groupTunnel.create(data, loginUser.getUserName());
            });
            component.addUpdatePersistStrategyFunction(() -> {
                GroupDO data = groupTunnel.get(command.getId());
                data.setParentId(command.getParentId());
                data.setName(command.getName());
                return groupTunnel.update(data, loginUser.getUserName());
            });
            return component.persist();

        }).flatMap(count -> ServerResponse.ok().bodyValue(defaultSuccessful()));
    }

}
