//package com.example.demo.liuyi.consumer;
//
//import com.example.demo.liuyi.Service.CreateRedService;
//import com.example.demo.liuyi.dao.redPackage;
//import com.google.common.util.concurrent.AtomicDouble;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Consumer implements Runnable{
//    private final Logger Log = LoggerFactory.getLogger(this.getClass());
//    CreateRedService p;
//    int user;
//    Consumer(CreateRedService p, int user){
//        this.p=p;
//        this.user=user;
//    }
//    @Override
//    public void run() {
////        Log.info("用户{}.消耗了{},还剩下{}",user,p.pop(),p.getMoney());
//    }
//
//    public static void main(String[] args) {
//        redPackage redP=new redPackage();
//        redP.setNumber(100);
//        AtomicDouble c=new AtomicDouble(10);
//        redP.setMoney(c);
//        CreateRedService p=new CreateRedService();
//        p.init(redP);
//        int a=1;
////        while (a==1){
////
////        }
//        for(int i=0;i<100;i++){
//            new Consumer(p,i+1).run();
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        while (a==1){
//
//        }
//    }
//}
