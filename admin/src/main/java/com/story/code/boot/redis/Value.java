package com.story.code.boot.redis;

import com.story.code.helper.StringHelper;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis普通Value操作
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/15 by Storys.Zhang
 */
public class Value {

    private RedisTemplate<String, Object> redisTemplate;

    public Value(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public <T> T get(String key, Class<T> tClass) {
        return StringHelper.isBlank(key) ? null : (T) redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Object value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
        return true;
    }
}
