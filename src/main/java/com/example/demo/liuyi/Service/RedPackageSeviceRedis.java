package com.example.demo.liuyi.Service;

import com.example.demo.liuyi.component.cache.RedisCache;
import com.example.demo.liuyi.component.cache.core.RedisCacheCore;
import com.example.demo.liuyi.dao.BaseRedPackage;
import com.example.demo.liuyi.dao.RedPackageFactory;
import com.example.demo.liuyi.dao.mapper.RedPackageMapper;
import com.example.demo.liuyi.manager.redPackageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RedPackageSeviceRedis {
    @Autowired
    RedisCache cache;
    @Autowired
    redPackageManager redManager;
    @Transactional
    public int create(RedPackageFactory r){

        pushMoney(r);

        redManager.createRedPackage(r.convert());

        return 0;
    }
    public void pushMoney(RedPackageFactory r){
        long userid=r.getUserid();
        long id=r.getUid();
        r.create();
        while (!r.isEmpty()) {
            cache.lpush(String.valueOf(id),String.valueOf(r.pop()));
        }
        cache.expire(String.valueOf(id),r.getExpire());
    }
}
