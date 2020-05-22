package com.story.code.app.sys.handler;

import com.story.code.app.sys.command.UserPersistCommand;
import com.story.code.app.sys.converter.UserAppConverter;
import com.story.code.app.sys.query.UserPageListQuery;
import com.story.code.app.sys.validator.UserPersistValidator;
import com.story.code.app.sys.vo.UserPageListVO;
import com.story.code.boot.security.SecurityUtils;
import com.story.code.boot.security.TokenProvider.TokenLoginUser;
import com.story.code.common.ApiResponseVO;
import com.story.code.component.page.PageComponent;
import com.story.code.component.page.vo.PageVO;
import com.story.code.domain.sys.dto.UserPersistDTO;
import com.story.code.domain.sys.repository.UserRepository;
import com.story.code.infrastructure.tunnel.dataobject.sys.UserDO;
import com.story.code.infrastructure.tunnel.datatunnel.UserTunnelI;
import com.story.code.infrastructure.tunnel.param.sys.UserPageListParam;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/8 by Storys.Zhang
 */
@Component
public class UserHandler {

    @Autowired
    private UserTunnelI userTunnel;
    @Autowired
    private UserAppConverter userAppConverter;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserPersistValidator userPersistValidator;

    public Mono<ServerResponse> page(ServerRequest request) {
        return request.bodyToMono(UserPageListQuery.class).map(query -> {
                PageComponent<UserPageListParam, UserDO, UserPageListVO> component = new PageComponent(userAppConverter.toParam(query), query.getPage());
                component.buildDataListFunction(userTunnel::pageList);
                component.buildConvertVoFunction(userAppConverter::doToVo);
                return component.page();
            }
        ).flatMap(page -> ServerResponse.ok().bodyValue(ApiResponseVO.<PageVO<UserPageListVO>>create().data(page).buildSuccess()));
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        return persist(request, userPersistValidator::validateAdd);
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return persist(request, userPersistValidator::validateUpdate);
    }

    private Mono<ServerResponse> persist(ServerRequest request, Consumer<UserPersistCommand> validate) {
        TokenLoginUser loginUser = SecurityUtils.getLoginUser(request.exchange().getRequest());
        return request.bodyToMono(UserPersistCommand.class).doOnNext(validate)
            .map(command -> {
                UserPersistDTO dto = userAppConverter.toDto(command);
                dto.setLoginUser(loginUser);
                return dto;
            }).map(userRepository::persist)
            .flatMap(count -> ServerResponse.ok().bodyValue(ApiResponseVO.defaultSuccessful()));
    }
}
