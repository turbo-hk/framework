package com.story.code.app.sys.controller;

import com.story.code.app.sys.command.LoginCommand;
import com.story.code.app.sys.service.SecurityService;
import com.story.code.app.sys.vo.LoginVO;
import com.story.code.boot.security.ReactiveServerSecurityContextRepository;
import com.story.code.boot.security.TokenAuthentication;
import com.story.code.boot.security.AuthenticationManager;
import com.story.code.common.ApiResponseVO;
import java.util.Objects;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/20 by Storys.Zhang
 */
@Slf4j
@RestController
@RequestMapping(value = "/0")
public class SecurityController {

    @Autowired
    private AuthenticationManager jwtAuthenticationManager;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private ReactiveServerSecurityContextRepository serverSecurityContextRepository;

    @RequestMapping("/login")
    private Mono<ApiResponseVO<LoginVO>> login(@RequestBody LoginCommand command, ServerWebExchange exchange) {
        final String token = UUID.randomUUID().toString().replaceAll("-", "");
        TokenAuthentication tokenAuthentication = new TokenAuthentication(token, command.getLoginName(), command.getPassword());
        return Mono.just(command)
            .filter(Objects::nonNull)
            .map(loginVo -> this.jwtAuthenticationManager.authenticate(tokenAuthentication))
            .flatMap(authenticationMono -> authenticationMono)
            .subscribeOn(Schedulers.elastic())
            .doOnSuccess(ReactiveSecurityContextHolder::withAuthentication)
            .doOnSuccess(auth -> serverSecurityContextRepository.save(exchange, new SecurityContextImpl(tokenAuthentication)))
            .map(authentication -> securityService.login(token))
            .switchIfEmpty(Mono.error(new UsernameNotFoundException("Bad request")));
    }
}
