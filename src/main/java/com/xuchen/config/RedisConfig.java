package com.xuchen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisPoolConfig getJedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }


    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisConnectionFactory getConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPoolConfig(getJedisPoolConfig());
        return factory;
    }

    @Bean("redisTemplate")
    public RedisTemplate getRedisTemplate(){
        RedisTemplate template = new StringRedisTemplate();
        RedisSerializer redisSerializer =new StringRedisSerializer();
        RedisSerializer jacksonRedisSerializer =new GenericJackson2JsonRedisSerializer();
        template.setConnectionFactory(getConnectionFactory());
        template.setKeySerializer(redisSerializer);
        template.setHashKeySerializer(redisSerializer);
        template.setValueSerializer(jacksonRedisSerializer);
        return template;
    }
}
