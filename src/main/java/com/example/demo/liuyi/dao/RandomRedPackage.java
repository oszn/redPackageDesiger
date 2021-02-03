package com.example.demo.liuyi.dao;

import com.example.demo.liuyi.component.RPconfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class RandomRedPackage extends RedPackageFactory {
//    @Autowired
//    redPackageManager redManager;
    private final Logger Log = LoggerFactory.getLogger(this.getClass());
    public LinkedBlockingQueue<Integer> getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    private int totalnumber;
    private LinkedBlockingQueue<Integer> queue;
    @Override
    public void distribution() {
        setQueue(new LinkedBlockingQueue<>());
//        redbit=r;
        Random random=new Random(System.currentTimeMillis());
        for(int i=0;i<getNumber();i++){
            int rnum= Math.abs(random.nextInt())% RPconfig.MAX_NUMBER+1;
            totalnumber=totalnumber+rnum;
            queue.add(rnum);
        }
        Log.info("init final");
    }

    @Override
    public void create() {
        distribution();
//        redManager.createRedPackage(baseRedPackage.convert());
    }

    @Override
    public synchronized double pop() {
        double a=0;
        //        System.out.println(queue.size());
        try {
            if(getQueue().size()!=0)
                a=getOrimoney().doubleValue()*((double)queue.poll()/totalnumber);
            if(queue.size()==0) {
                a=getMoney().doubleValue();
                getMoney().set(0);
                return a;
            }
            getMoney().set(getMoney().doubleValue()-a);
            return a;
        }catch (NullPointerException e){
            return 0;
        }
    }

    @Override
    public void put() {

    }

//    @Override
//    public boolean isExpire() {
//        if(redManager.ifexpire(baseRedPackage.getUid(),baseRedPackage.getExpire())==1)
//            return true;
//        return false;
//    }

    @Override
    public void clear() {
        queue.clear();
        Log.info("到期了，还剩下{}",getMoney());
        getMoney().set(0);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
