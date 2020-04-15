package com.story.code.sys;

import com.story.code.ApplicationTests;
import com.story.code.boot.redis.RedisOps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/15 by Storys.Zhang
 */
public class RedisTests extends ApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisOps redisOpsContext;

    @Test
    public void testPool(){
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        System.out.println(redisTemplate.getConnectionFactory());
        boolean test = redisOpsContext.value.set("test", "123456", 60);
        System.out.println(test);
        String test1 = redisOpsContext.value.get("test", String.class);
        System.out.println(test1);
    }
}
