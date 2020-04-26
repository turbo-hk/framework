package com.story.code.boot.security;

import com.story.code.boot.SpringContextHolder;
import com.story.code.boot.security.request.ReactiveRequestContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    public static Mono<String> getUserFromRequest() {
        return ReactiveRequestContextHolder.getRequest().flatMap(exchange -> exchange.getPrincipal()
            .cast(UsernamePasswordAuthenticationToken.class)
            .map(UsernamePasswordAuthenticationToken::getPrincipal)
            .cast(AuthenticationUser.class)
            .map(AuthenticationUser::getUsername));
    }

}
