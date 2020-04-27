package com.story.code.boot.redis;

import javax.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Redis操作
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/15 by Storys.Zhang
 */
@Component
public class RedisOps {

    @Autowired
    @Getter
    private ReactiveRedisTemplate redisTemplate;

    @PostConstruct
    public void init() {
        this.value = new Value(redisTemplate);
        this.hash = new Hash(redisTemplate);
    }

    public Value value;
    public Hash hash;

}
