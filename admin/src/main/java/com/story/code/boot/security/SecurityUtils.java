package com.story.code.boot.security;

import com.story.code.boot.SpringContextHolder;
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

    public static Authentication getAuthentication(String token) {
        ReactiveServerSecurityContextRepository contextRepository = SpringContextHolder.getBean(ReactiveServerSecurityContextRepository.class);
        return contextRepository.getTokenCache().get(token).getAuthentication();
    }

    public static Mono<String> getUserFromRequest(ServerWebExchange serverWebExchange) {
        return serverWebExchange.getPrincipal()
            .cast(UsernamePasswordAuthenticationToken.class)
            .map(UsernamePasswordAuthenticationToken::getPrincipal)
            .cast(AuthenticationUser.class)
            .map(AuthenticationUser::getUsername);
    }

}
