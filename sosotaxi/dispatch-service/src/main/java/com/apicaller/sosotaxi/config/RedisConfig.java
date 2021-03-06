package com.apicaller.sosotaxi.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public RedisTemplate<String, Serializable>
            redisTemplate(LettuceConnectionFactory factory){
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());


        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());

        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate strRedisTemplate(LettuceConnectionFactory factory){
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());


        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}
