package com.story.code.boot.redis;

import com.story.code.helper.StringHelper;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import reactor.core.publisher.Mono;

/**
 * Redis普通Value操作
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/15 by Storys.Zhang
 */
public class Value {

    private ReactiveRedisTemplate redisTemplate;

    public Value(ReactiveRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public <V> Mono<V> get(String key) {
        return StringHelper.isBlank(key) ? Mono.empty() : redisTemplate.opsForValue().get(key);
    }

    public <V> Mono<Boolean> set(String key, V value, long time, ChronoUnit timeUnit) {
        if (time > 0) {
            return redisTemplate.opsForValue().set(key, value, Duration.of(time, timeUnit));
        } else {
            return redisTemplate.opsForValue().set(key, value);
        }
    }

    public Mono<Boolean> delete(String key) {
        return redisTemplate.opsForValue().delete(key);
    }
}
