package com.story.code.boot.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/23 by Storys.Zhang
 */
@Slf4j
@Component
public class TokenProvider {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean validateToken(String authToken){
        return  true;
    }

}
