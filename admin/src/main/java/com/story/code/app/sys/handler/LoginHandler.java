package com.story.code.app.sys.handler;

import com.story.code.app.sys.command.LoginCommand;
import com.story.code.app.sys.vo.LoginVO;
import com.story.code.boot.security.AuthenticationManager;
import com.story.code.boot.security.ReactiveServerSecurityContextRepository;
import com.story.code.boot.security.TokenAuthentication;
import com.story.code.common.ApiResponseVO;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/5/7 by Storys.Zhang
 */
@Slf4j
@Component
public class LoginHandler {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ReactiveServerSecurityContextRepository serverSecurityContextRepository;

    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(LoginCommand.class)
            .filter(Objects::nonNull)
            .map(command -> this.authenticationManager.authenticate(new TokenAuthentication(command.getLoginName(), command.getPassword())))
            .flatMap(authenticationMono -> authenticationMono)
            .subscribeOn(Schedulers.elastic())
            .doOnSuccess(ReactiveSecurityContextHolder::withAuthentication)
            .map(auth -> serverSecurityContextRepository.saveToken(request.exchange(), new SecurityContextImpl(auth)))
            .flatMap(authenticationMono -> authenticationMono)
            .flatMap(authentication -> ServerResponse.ok().bodyValue(login(((TokenAuthentication) authentication).getToken())))
            .switchIfEmpty(Mono.error(new UsernameNotFoundException("Bad request")));
    }

    public Mono<ServerResponse> logout(ServerRequest request) {
        return serverSecurityContextRepository.remove(request.exchange()).flatMap(result -> ServerResponse.ok().bodyValue(ApiResponseVO.defaultSuccessful()));
    }

    private ApiResponseVO<LoginVO> login(String token) {
        LoginVO vo = new LoginVO();
        vo.setToken(token);
        return ApiResponseVO.<LoginVO>create().data(vo).buildSuccess();
    }

}
