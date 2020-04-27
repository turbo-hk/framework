package com.story.code.boot.security;

import com.story.code.boot.redis.RedisOps;
import com.story.code.helper.StringHelper;
import com.story.code.helper.UuidHelper;
import com.story.code.helper.crypto.RsaHelper;
import com.story.code.helper.crypto.RsaHelper.RsaKeyPair;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/23 by Storys.Zhang
 */
@Slf4j
public class TokenProvider {

    @Autowired
    private RedisOps redisOps;

    private DatabaseReactiveUserDetailService databaseReactiveUserDetailService;

    public TokenProvider(DatabaseReactiveUserDetailService databaseReactiveUserDetailService) {
        this.databaseReactiveUserDetailService = databaseReactiveUserDetailService;
    }

    private RsaKeyPair rsaKeyPair;


    private String RSA_SEED = "handongzhengfawei";
    private long expireSeconds = 180;
    private String redisPrefix = "login:token:";

    @PostConstruct
    public void init() throws Exception {
        log.debug("初始化登录Token生成...");
        this.rsaKeyPair = RsaHelper.generateKeyPair(RSA_SEED);
        log.debug("登录Token->PrivateKey={}", this.rsaKeyPair.getPrivateKey());
        log.debug("登录Token->PublicKey={}", this.rsaKeyPair.getPublicKey());
    }

    @SneakyThrows
    public String createToken(AuthenticationUser user) {
        String originToken = StringHelper.join(UuidHelper.uuid(), "^", user.getId());
        String encryptToken = RsaHelper.encrypt(rsaKeyPair.getPrivateKey(), originToken);
        return encryptToken;
    }

    public Mono<Boolean> saveToken(String encryptToken, SecurityContext context) {
        String redisKey = StringHelper.join(redisPrefix, encryptToken);
        Mono<Boolean> mono = redisOps.value.set(redisKey, context, expireSeconds, ChronoUnit.SECONDS);
        return mono;
    }

    public Mono<SecurityContext> get(String token) {
        String redisKey = StringHelper.join(redisPrefix, token);
 /*       return redisOps.value.get(redisKey).flatMap(userId ->
            databaseReactiveUserDetailService.findByUserId((Long) userId)).map(user -> {
            TokenAuthentication tokenAuthentication = new TokenAuthentication(token, user.getUsername(), user.getPassword(), user.getAuthorities());
            return tokenAuthentication;
        }).map(tokenAuthentication -> new SecurityContextImpl(tokenAuthentication));*/
        return redisOps.value.get(redisKey);
    }

    public Mono<Boolean> validateToken(String authToken) {
        try {
            RsaHelper.encrypt(rsaKeyPair.getPublicKey(), authToken);
        } catch (Exception e) {
            log.error("非法的token:{}", authToken);
            return Mono.empty();
        }
        String redisKey = StringHelper.join(redisPrefix, authToken);
        Mono<Long> longMono = redisOps.value.get(redisKey);
        return longMono.map(id -> Objects.nonNull(id));
    }

}
