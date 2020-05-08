package com.story.code.app.sys.handler;

import static com.story.code.common.ApiResponseVO.defaultSuccessful;

import com.story.code.app.sys.command.MenuPersistCommand;
import com.story.code.app.sys.converter.MenuAppConverter;
import com.story.code.app.sys.query.MenuPageListQuery;
import com.story.code.app.sys.vo.MenuPageListVO;
import com.story.code.common.ApiResponseVO;
import com.story.code.common.page.reactive.PageReactiveWrapper;
import com.story.code.component.page.vo.PageVO;
import com.story.code.infrastructure.tunnel.datatunnel.ResourceMenuTunnelI;
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
    private MenuAppConverter menuConverter;

    public Mono<ServerResponse> page(ServerRequest request) {

        return request.bodyToMono(MenuPageListQuery.class).flatMap(query -> {
            Mono<PageVO<MenuPageListVO>> page = PageReactiveWrapper
                .page(resourceMenuTunnel::pageList, menuConverter::doToVo, query.getPage(), menuConverter.toParam(query));
            return page;
        }).flatMap(page -> ServerResponse.ok().bodyValue(ApiResponseVO.<PageVO<MenuPageListVO>>create().data(page).buildSuccess()));
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        return request.bodyToMono(MenuPersistCommand.class).flatMap(count -> ServerResponse.ok().bodyValue(defaultSuccessful()));
    }


}
