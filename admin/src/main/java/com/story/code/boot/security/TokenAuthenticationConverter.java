package com.story.code.boot.security;

import com.story.code.helper.StringHelper;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import org.springframework.security.core.Authentication;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/21 by Storys.Zhang
 */
public class TokenAuthenticationConverter implements Function<ServerWebExchange, Mono<Authentication>> {

    private static final String BEARER = "Bearer ";
    private static final Predicate<String> matchBearerLength = authValue -> authValue.length() > BEARER.length();
    private static final Function<String, String> isolateBearerValue = authValue -> authValue.substring(BEARER.length(), authValue.length());


    @Override
    public Mono<Authentication> apply(ServerWebExchange serverWebExchange) {
        return Mono.justOrEmpty(serverWebExchange)
            .map(SecurityUtils::getTokenFromRequest)
            .filter(Objects::nonNull)
            .filter(matchBearerLength)
            .map(isolateBearerValue)
            .filter(token -> !StringHelper.isBlank(token))
            .flatMap(SecurityUtils::getAuthentication)
            .filter(Objects::nonNull)
            //  .switchIfEmpty(Mono.error(new RequiredLoginException("token is expired")))
            ;
    }

    public static String formatToken(String token) {
        if (matchBearerLength.test(token)) {
            return isolateBearerValue.apply(token);
        }
        return null;
    }
}
