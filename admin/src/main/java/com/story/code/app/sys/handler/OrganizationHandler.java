package com.story.code.app.sys.handler;

import static com.story.code.common.ApiResponseVO.defaultSuccessful;
import static com.story.code.infrastructure.tunnel.common.Constants.DEFAULT_LONG;

import com.story.code.app.sys.command.OrganizationPersistCommand;
import com.story.code.app.sys.converter.OrganizationAppConverter;
import com.story.code.app.sys.query.OrganizationPageListQuery;
import com.story.code.app.sys.validator.OrganizationPersistValidator;
import com.story.code.app.sys.vo.OrganizationPageListVO;
import com.story.code.boot.exception.custom.DataPersistenceException;
import com.story.code.boot.security.SecurityUtils;
import com.story.code.boot.security.TenantIdUtil;
import com.story.code.boot.security.TokenProvider.TokenLoginUser;
import com.story.code.common.ApiResponseVO;
import com.story.code.component.page.PageComponent;
import com.story.code.component.page.vo.PageVO;
import com.story.code.component.saveorupdate.DataPersistComponent;
import com.story.code.component.saveorupdate.ValidatorFunction;
import com.story.code.infrastructure.tunnel.dataobject.sys.OrganizationDO;
import com.story.code.infrastructure.tunnel.datatunnel.OrganizationTunnelI;
import com.story.code.infrastructure.tunnel.param.sys.OrganizationPageListParam;
import java.util.Optional;
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
public class OrganizationHandler {

    @Autowired
    private OrganizationTunnelI organizationTunnel;

    @Autowired
    private OrganizationAppConverter organizationAppConverter;

    @Autowired
    private OrganizationPersistValidator organizationPersistValidator;

    public Mono<ServerResponse> page(ServerRequest request) {
        return request.bodyToMono(OrganizationPageListQuery.class).map(query -> {
            PageComponent<OrganizationPageListParam, OrganizationDO, OrganizationPageListVO> component = new PageComponent<>(
                organizationAppConverter.toParam(query), query.getPage());
            component.buildDataListFunction(organizationTunnel::pageList);
            component.buildConvertVoFunction(organizationAppConverter::doToVo);
            return component.page();
        }).flatMap(page -> ServerResponse.ok().bodyValue(ApiResponseVO.<PageVO<OrganizationPageListVO>>create().data(page).buildSuccess()));
    }

    public Mono<ServerResponse> tree(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        return persist(request, organizationPersistValidator::validateAdd);
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return persist(request, organizationPersistValidator::validateUpdate);
    }

    private Mono<ServerResponse> persist(ServerRequest request, ValidatorFunction<OrganizationPersistCommand> validatorFunction) {
        TokenLoginUser loginUser = SecurityUtils.getLoginUser(request.exchange().getRequest());
        return request.bodyToMono(OrganizationPersistCommand.class).map(command -> {
            command.setParentId(Optional.ofNullable(command.getParentId()).orElse(DEFAULT_LONG));
            return command;
        }).map(command -> {
            DataPersistComponent<OrganizationPersistCommand, OrganizationDO> component = new DataPersistComponent(command, command.getId());
            component.addValidatorFunction(validatorFunction);
            component.addCreatePersistStrategyFunction(() -> {
                OrganizationDO record = new OrganizationDO();
                record.setName(command.getName());
                record.setParentId(command.getParentId());
                record.setTenantId(TenantIdUtil.getTenantId());
                return organizationTunnel.create(record, loginUser.getUserName());
            });
            component.addUpdatePersistStrategyFunction(() -> {
                OrganizationDO data = organizationTunnel.get(command.getId());
                data.setName(command.getName());
                data.setParentId(command.getParentId());
                return organizationTunnel.update(data, loginUser.getUserName());
            });
            return component.persist();
        }).doOnSuccess(count -> DataPersistenceException.verify(count, "保存组织机构失败")).flatMap(count -> ServerResponse.ok().bodyValue(defaultSuccessful()));
    }
}
