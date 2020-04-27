package com.story.code.boot.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * Redis 配置
 *
 * @author storys.zhang@gmail.com
 * <p>
 * Created at 2020/4/15 by Storys.Zhang
 */
@Slf4j
@Configuration
public class LettuceRedisConfiguration {

/*    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }*/


    @Primary
    @Bean
    public ReactiveRedisTemplate<Object, Object> reactiveRedisTemplate(LettuceConnectionFactory factory, ResourceLoader resourceLoader) {
        log.debug("Redis Configuration init.............");
        JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer(
            resourceLoader.getClassLoader());
        RedisSerializationContext<Object, Object> serializationContext = RedisSerializationContext
            .newSerializationContext().key(jdkSerializer).value(jdkSerializer).hashKey(jdkSerializer)
            .hashValue(jdkSerializer).build();
        return new ReactiveRedisTemplate<>(factory, serializationContext);
    }
}
