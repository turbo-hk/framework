package com.story.code.boot.security;

import com.story.code.helper.StringHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
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

    @Getter
    private final Map<String, SecurityContext> tokenCache = new ConcurrentHashMap<>();

    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
        if (context.getAuthentication() instanceof TokenAuthentication) {
            TokenAuthentication authentication = (TokenAuthentication) context.getAuthentication();
            tokenCache.put(authentication.getToken(), context);
        }
        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        String authorization = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StringHelper.isBlank(authorization) || !tokenCache.containsKey(authorization)) {
            return Mono.empty();
        }
        return Mono.just(tokenCache.get(authorization));
    }
}
