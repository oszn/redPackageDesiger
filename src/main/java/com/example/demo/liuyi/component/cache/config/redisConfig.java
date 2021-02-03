package com.example.demo.liuyi.component.cache.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;

@Configuration
public class redisConfig {
    protected RedisConnectionFactory createConnectionFactory(String host, int port, int database, String password) {
        RedisStandaloneConfiguration configuration =
                new RedisStandaloneConfiguration(host, port);
        configuration.setDatabase(database);
        configuration.setPassword(password);
        return new JedisConnectionFactory(configuration);
    }
}
