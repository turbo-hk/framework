package com.story.code.app.sys.handler;

import com.story.code.app.sys.converter.UserAppConverter;
import com.story.code.app.sys.query.UserPageListQuery;
import com.story.code.app.sys.vo.UserPageListVO;
import com.story.code.common.ApiResponseVO;
import com.story.code.common.page.reactive.PageReactiveWrapper;
import com.story.code.component.page.vo.PageVO;
import com.story.code.infrastructure.tunnel.datatunnel.UserTunnelI;
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

    public Mono<ServerResponse> page(ServerRequest request) {
        return request.bodyToMono(UserPageListQuery.class).flatMap(query ->
            PageReactiveWrapper
                .page(userTunnel::page, userAppConverter::doToVo, query.getPage(), userAppConverter.toParam(query))
        ).flatMap(page -> ServerResponse.ok().bodyValue(ApiResponseVO.<PageVO<UserPageListVO>>create().data(page).buildSuccess()));
    }
}
