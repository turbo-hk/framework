package com.story.code.boot.security;

import java.util.Objects;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/23 by Storys.Zhang
 */
public class ReactiveServerSecurityContextRepository implements ServerSecurityContextRepository {

    private TokenProvider tokenProvider;

    public ReactiveServerSecurityContextRepository(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
        if (context.getAuthentication() instanceof TokenAuthentication) {
            TokenAuthentication authentication = (TokenAuthentication) context.getAuthentication();
            tokenProvider.saveToken(authentication.getToken(), context);
        }
        return Mono.empty();
    }

    public Mono<Authentication> saveToken(ServerWebExchange exchange, SecurityContext context) {
        if (context.getAuthentication() instanceof TokenAuthentication) {
            TokenAuthentication authentication = (TokenAuthentication) context.getAuthentication();
            return tokenProvider.saveToken(authentication.getToken(), context).map(v -> context.getAuthentication());
        }
        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        String authorization = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return tokenProvider.validateToken(authorization).filter(Objects::nonNull).flatMap(auth -> tokenProvider.get(authorization));
    }

    public Mono<Boolean> remove(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        String authorization = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return tokenProvider.remove(TokenAuthenticationConverter.formatToken(authorization));
    }
}
