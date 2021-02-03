package com.example.demo.liuyi.Service;

import com.example.demo.liuyi.component.exception.expireException;
import com.example.demo.liuyi.component.tools.expireDelaydElement;
import com.example.demo.liuyi.component.tools.threadQueue;
import com.example.demo.liuyi.dao.RedPackageFactory;

import com.example.demo.liuyi.manager.redPackageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class RedPackageService {
    @Autowired
    redPackageManager redManager;

    static threadQueue tqueue=new threadQueue();;
    static Map<Long, RedPackageFactory> cmap=new HashMap<>();
    private final Logger Log = LoggerFactory.getLogger(this.getClass());

    public RedPackageService() {
//        this.cmap = ;


        tqueue.insertMap(cmap);
        tqueue.setIfSwitch(true);
        Thread t=new Thread(tqueue);
        t.start();
    }

    @Transactional
    public void create(RedPackageFactory r){
        long uid= r.getUserid();
        long id=r.getUid();
        cmap.put(id,r);
        r.create();
        redManager.createRedPackage(r.convert());
        expireDelaydElement delaydElement=new expireDelaydElement();
        delaydElement.setBrd(r);
        tqueue.push(delaydElement);
    }

    public double popmoney(Long uid){

        try {
            double money=cmap.get(uid).pop();
            if(money!=0)
                return money;
            if(!isexpier(uid,cmap.get(uid).getExpire())){
                return money;
        }}catch (Exception  e){
            throw new expireException("红包过期");
        }
        return 0;
    }

    boolean isexpier(Long uid,long expire){
        if(redManager.ifexpire(uid,expire)==1)
            return true;
        return false;
    }







}
