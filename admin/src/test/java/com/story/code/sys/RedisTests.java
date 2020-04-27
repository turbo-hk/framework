package com.story.code.sys;

import com.story.code.ApplicationTests;
import com.story.code.boot.redis.RedisOps;
import java.time.temporal.ChronoUnit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import reactor.core.publisher.Mono;

/**
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/15 by Storys.Zhang
 */
public class RedisTests extends ApplicationTests {


    @Autowired
    private RedisOps redisOpsContext;

    @Test
    public void testPool() throws Exception {
        ReactiveRedisConnectionFactory connection = redisOpsContext.getRedisTemplate().getConnectionFactory();
        System.out.println(connection.getReactiveConnection().ping());
        Mono<Boolean> test = redisOpsContext.value.set("test", Long.valueOf("123456"), 60, ChronoUnit.SECONDS);
        System.out.println(test);
        Mono<Long> test1 = test.then(redisOpsContext.value.get("test"));
        System.out.println(test1);
        test1.subscribe(c -> System.out.println(c));

        Thread.sleep(10 * 1000);
    }
}
