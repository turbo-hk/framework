package com.story.code.boot.redis;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/15 by Storys.Zhang
 */
public class Hash {

    private RedisTemplate<String, Object> redisTemplate;

    public Hash(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
