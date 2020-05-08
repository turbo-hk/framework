package com.story.code.app.sys;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import com.story.code.app.sys.handler.LoginHandler;
import com.story.code.app.sys.handler.MenuHandler;
import com.story.code.app.sys.handler.OrganizationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/7 by Storys.Zhang
 */
@Configuration
public class SysRoutersConfiguration {

    @Bean
    public RouterFunction<ServerResponse> loginRoutersFunction(LoginHandler handler) {
        return RouterFunctions.route(RequestPredicates.POST("/sys/login").and(accept(APPLICATION_JSON)), handler::login);
    }

    @Bean
    public RouterFunction<ServerResponse> organizationRoutersFunction(OrganizationHandler handler) {
        return RouterFunctions.route(RequestPredicates.POST("/sys/organization/add").and(accept(APPLICATION_JSON)), handler::add);
    }

    @Bean
    public RouterFunction<ServerResponse> menuRoutersFunction(MenuHandler handler) {
        return RouterFunctions.route(RequestPredicates.POST("/sys/menu/page").and(accept(APPLICATION_JSON)), handler::page)
            .and(RouterFunctions.route(RequestPredicates.POST("/sys/menu/add").and(accept(APPLICATION_JSON)), handler::add));
    }

}
