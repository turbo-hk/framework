package com.story.code.boot.security;

import com.story.code.helper.StringHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/21 by Storys.Zhang
 */
@Slf4j
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private ReactiveUserDetailsService reactiveUserDetailsService;

    private Scheduler scheduler;

    private LoginPasswordEncoder passwordEncoder;

    public AuthenticationManager(ReactiveUserDetailsService reactiveUserDetailsService, LoginPasswordEncoder passwordEncoder) {
        this.reactiveUserDetailsService = reactiveUserDetailsService;
        this.scheduler = Schedulers.parallel();
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {

        if (authentication.isAuthenticated()) {
            return Mono.just(authentication);
        }
        return Mono.just(authentication)
            .switchIfEmpty(Mono.defer(this::raiseBadCredentials))
            .cast(UsernamePasswordAuthenticationToken.class)
            .flatMap(authenticationToken -> authenticateToken(authenticationToken))
            .publishOn(scheduler)
            .onErrorResume(e -> raiseBadCredentials(e))
            .filter(userDetails -> passwordEncoder.matches((String) authentication.getCredentials(), userDetails.getPassword()))
            .switchIfEmpty(Mono.defer(() -> raiseBadCredentials()))
            .map(u -> new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), u.getAuthorities()));
    }

    private <T> Mono<T> raiseBadCredentials() {
        return Mono.error(new BadCredentialsException("Invalid Credentials"));
    }

    private <T> Mono<T> raiseBadCredentials(Throwable e) {
        return Mono.error(new BadCredentialsException("Invalid Credentials", e));
    }

    private Mono<UserDetails> authenticateToken(final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
        String username = usernamePasswordAuthenticationToken.getName();

        log.info("checking authentication for user {}", username);

        if (StringHelper.isNotBlank(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
            log.info("authenticated user {}, setting security context", username);
            return reactiveUserDetailsService.findByUsername(username);
        }

        return Mono.empty();
    }
}
