package com.example.demo.liuyi.component.tools;

import com.example.demo.liuyi.dao.BaseRedPackage;
import com.example.demo.liuyi.dao.RedPackageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;

//@Component
public class threadQueue implements Runnable{
    public threadQueue() {
        this.queue = new DelayQueue<>();
    }

    public final Logger log= LoggerFactory.getLogger(this.getClass());
    private DelayQueue<expireDelaydElement> queue;
    Map<Long, RedPackageFactory> innerMap;
    public void insertMap(Map<Long, RedPackageFactory> r){
        innerMap=r;
    }

    public boolean isIfSwitch() {
        return IfSwitch;
    }

    public void setIfSwitch(boolean ifSwitch) {
        IfSwitch = ifSwitch;
    }
    public void push(expireDelaydElement q){
        queue.add(q);
    }
    private boolean IfSwitch;

    @Override
    public void run() {
        log.info("queue start!");
        while (IfSwitch){
            try {
                expireDelaydElement e=queue.take();
                log.info("id为{}的红包过期，剩下金额为{}",e.getBrd().getUid(),e.getBrd().getMoney());
                innerMap.remove(e.getBrd().getUid());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
