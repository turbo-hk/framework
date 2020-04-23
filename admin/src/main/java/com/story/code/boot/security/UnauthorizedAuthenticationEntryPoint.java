package com.story.code.boot.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/21 by Storys.Zhang
 */
@Slf4j
@Component
public class UnauthorizedAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {

    @Override
    public Mono<Void> commence(final ServerWebExchange exchange, final AuthenticationException e) {

        log.warn("Url Unauthorized , {}", exchange.getRequest().getURI().getPath());
        return Mono.fromRunnable(() -> exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED));
    }
}
