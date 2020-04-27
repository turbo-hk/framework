package com.story.code.boot.security;

import com.story.code.boot.SpringContextHolder;
import com.story.code.boot.security.request.ReactiveRequestContextHolder;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/22 by Storys.Zhang
 */
@Slf4j
public class SecurityUtils {

    public static String getTokenFromRequest(ServerWebExchange serverWebExchange) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        String token = request.getHeaders().getFirst("Authorization");
        log.debug("Token: {}", token);
        return token;
    }

    public static Mono<Authentication> getAuthentication(String token) {
        TokenProvider tokenProvider = SpringContextHolder.getBean(TokenProvider.class);
        return tokenProvider.get(token).map(securityContext -> securityContext.getAuthentication());
    }

    public static Mono<Long> getUserId() {
        return ReactiveRequestContextHolder.getRequest().map(request -> request.getHeaders().getFirst("Authorization"))
            .filter(Objects::nonNull)
            .map(token -> TokenAuthenticationConverter.formatToken(token))
            .map(token -> SpringContextHolder.getBean(TokenProvider.class).getUserId(token));

    }

}
