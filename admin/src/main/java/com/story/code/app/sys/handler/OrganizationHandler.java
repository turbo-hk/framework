package com.story.code.app.sys.handler;

import static com.story.code.common.ApiResponseVO.defaultSuccessful;
import static com.story.code.infrastructure.tunnel.common.Constants.DEFAULT_LONG;

import com.story.code.app.sys.command.OrganizationPersistCommand;
import com.story.code.app.sys.validator.OrganizationPersistValidator;
import com.story.code.boot.exception.custom.DataPersistenceException;
import com.story.code.boot.security.SecurityUtils;
import com.story.code.boot.security.TenantIdUtil;
import com.story.code.boot.security.TokenProvider.TokenLoginUser;
import com.story.code.component.saveorupdate.DataPersistComponent;
import com.story.code.component.saveorupdate.ValidatorFunction;
import com.story.code.helper.OrganizationUidGenerator;
import com.story.code.helper.StringHelper;
import com.story.code.infrastructure.tunnel.dataobject.sys.OrganizationDO;
import com.story.code.infrastructure.tunnel.dataobject.sys.ResourceMenuDO;
import com.story.code.infrastructure.tunnel.datatunnel.OrganizationTunnelI;
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
    private OrganizationPersistValidator organizationPersistValidator;

    public Mono<ServerResponse> page(ServerRequest request) {
        return persist(request);
    }
    public Mono<ServerResponse> tree(ServerRequest request) {
        return persist(request);
    }
    public Mono<ServerResponse> add(ServerRequest request) {
        return persist(request);
    }
    public Mono<ServerResponse> update(ServerRequest request) {
        return persist(request);
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
                OrganizationDO maxByParentId = organizationTunnel.maxByParentId(command.getParentId());
                OrganizationDO maxOrganization = Optional.ofNullable(maxByParentId).orElse(new OrganizationDO() {{
                    setParentUid(organizationTunnel.get(command.getParentId()).getUid());
                }});
                String uid = OrganizationUidGenerator.generate(StringHelper.nullToEmpty(maxOrganization.getParentUid()), maxOrganization.getUid());
                OrganizationDO record = new OrganizationDO();
                record.setName(command.getName());
                record.setParentId(command.getParentId());
                record.setParentUid(StringHelper.nullToEmpty(maxOrganization.getParentUid()));
                record.setTenantId(TenantIdUtil.getTenantId());
                record.setUid(uid);
                return organizationTunnel.create(record, loginUser.getUserName());
            });
            component.addUpdatePersistStrategyFunction(() -> {
                OrganizationDO data = organizationTunnel.get(command.getId());
                data.setName(command.getName());
                data.setParentId(command.getParentId());
                data.setParentUid(StringHelper.nullToEmpty(maxOrganization.getParentUid()));
                data.setUid(uid);
                return organizationTunnel.update(data, loginUser.getUserName());
            });
            return component.persist();
        }).doOnSuccess(count -> DataPersistenceException.verify(count, "保存组织机构失败")).flatMap(count -> ServerResponse.ok().bodyValue(defaultSuccessful()));
    }
}
