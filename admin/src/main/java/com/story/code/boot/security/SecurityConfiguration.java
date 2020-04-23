package com.story.code.boot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/20 by Storys.Zhang
 */
@Configuration
@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
public class SecurityConfiguration {

    private static final String[] AUTH_WHITELIST = {
        "/**/login"
    };


    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http, UnauthorizedAuthenticationEntryPoint entryPoint) {
        http.httpBasic().disable()
            .formLogin().disable()
            .csrf().disable()
            .logout().disable();
        http
            .exceptionHandling()
            .authenticationEntryPoint(entryPoint)
            .and()
            .authorizeExchange()
            .and()
            .authorizeExchange()
            .pathMatchers(HttpMethod.OPTIONS)
            .permitAll()
            .and()
            .addFilterAt(webFilter(), SecurityWebFiltersOrder.AUTHORIZATION)
            .authorizeExchange()
            .pathMatchers(AUTH_WHITELIST).permitAll()
            .pathMatchers("/**").authenticated()
            .anyExchange()
            .authenticated();

        return http.build();
    }

    private Mono<AuthorizationDecision> currentUserMatchesPath(Mono<Authentication> authenticationMono, AuthorizationContext authorizationContext) {
        return authenticationMono
            .map(authentication -> authorizationContext.getVariables().get("user").equals(authentication.getName()))
            .map(AuthorizationDecision::new);
    }

    @Bean
    public AuthenticationWebFilter webFilter() {
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(authenticationManager());
        authenticationWebFilter.setServerAuthenticationConverter(tokenAuthenticationConverter()::apply);
        authenticationWebFilter.setRequiresAuthenticationMatcher(new HeadersExchangeMatcher());
        authenticationWebFilter.setSecurityContextRepository(serverSecurityContextRepository());
        authenticationWebFilter.setAuthenticationSuccessHandler(serverAuthenticationSuccessHandler());
        return authenticationWebFilter;
    }

    @Bean
    public LoginPasswordEncoder passwordEncoder() {
        return new LoginPasswordEncoder();
    }

    @Bean
    public TokenAuthenticationConverter tokenAuthenticationConverter() {
        return new TokenAuthenticationConverter();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new AuthenticationManager(reactiveUserDetailsService(), passwordEncoder());
    }

    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService() {
        return new DatabaseReactiveUserDetailService();
    }


    @Bean
    public ReactiveServerSecurityContextRepository serverSecurityContextRepository() {
        return new ReactiveServerSecurityContextRepository();
    }

    @Bean
    public ReactiveServerAuthenticationSuccessHandler serverAuthenticationSuccessHandler() {
        return new ReactiveServerAuthenticationSuccessHandler();
    }
}
