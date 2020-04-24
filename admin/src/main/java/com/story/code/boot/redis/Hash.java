package com.story.code.boot.redis;

import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/15 by Storys.Zhang
 */
public class Hash {

    private ReactiveRedisTemplate redisTemplate;

    public Hash(ReactiveRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
