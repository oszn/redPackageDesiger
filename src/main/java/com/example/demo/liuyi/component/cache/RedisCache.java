package com.example.demo.liuyi.component.cache;

import com.example.demo.liuyi.component.cache.config.RedisTemplateConstant;
import com.example.demo.liuyi.component.cache.core.RedisCacheCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component("RedisCache")
public class RedisCache extends RedisCacheCore {

    @Qualifier(RedisTemplateConstant.CacheRedisTemplate)
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostConstruct
    public void init(){
        super.setRedisTemplate(redisTemplate);
    }
}
