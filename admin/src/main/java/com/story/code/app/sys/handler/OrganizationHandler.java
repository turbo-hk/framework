package com.story.code.app.sys.handler;

import static com.story.code.common.ApiResponseVO.defaultSuccessful;
import static com.story.code.infrastructure.tunnel.common.Constants.DEFAULT_LONG;

import com.story.code.app.sys.command.OrganizationPersistCommand;
import com.story.code.boot.exception.custom.DataPersistenceException;
import com.story.code.boot.security.SecurityUtils;
import com.story.code.boot.security.TenantIdUtil;
import com.story.code.boot.security.TokenProvider.TokenLoginUser;
import com.story.code.helper.OrganizationUidGenerator;
import com.story.code.helper.StringHelper;
import com.story.code.infrastructure.tunnel.dataobject.sys.OrganizationDO;
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

    public Mono<ServerResponse> add(ServerRequest request) {
        TokenLoginUser loginUser = SecurityUtils.getLoginUser(request.exchange().getRequest());
        return request.bodyToMono(OrganizationPersistCommand.class).map(command -> {
            command.setParentId(Optional.ofNullable(command.getParentId()).orElse(DEFAULT_LONG));
            return command;
        }).map(command -> {
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
        }).doOnSuccess(count -> DataPersistenceException.verify(count, "保存组织机构失败")).flatMap(count -> ServerResponse.ok().bodyValue(defaultSuccessful()));
    }
}
