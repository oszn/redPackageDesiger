package com.example.demo.liuyi.controller;


import com.example.demo.liuyi.Service.RedPackageService;
import com.example.demo.liuyi.Service.RedPackageSeviceRedis;
import com.example.demo.liuyi.dao.RandomRedPackage;
import com.example.demo.liuyi.dao.RandomRedPackageNoSafe;
import com.example.demo.liuyi.dao.RedPackageFactory;
import com.example.demo.liuyi.component.tools.generateId;
import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rebPackageController {
    @Value("${mybatis.mapperLocations}")
    String s;
    @Autowired
    RedPackageService red;
    @Autowired
    RedPackageSeviceRedis redredis;
    @PostMapping("/create")
    public String createRB(@RequestParam("money")double money, @RequestParam("number") int number,@RequestParam("userid") int id,@RequestParam(value = "expire",required = false,defaultValue = "60")long expire){
        System.out.println(s);
        RedPackageFactory r=new RandomRedPackageNoSafe() ;
        AtomicDouble cmoney=new AtomicDouble(money);
        r.setMoney(cmoney);
        r.setNumber(number);
        r.setDate(System.currentTimeMillis());
        r.setUserid(id);
        r.setExpire(expire);
        r.setOrimoney(cmoney);
        long uid= generateId.fromtime(id);
        r.setUid(uid);
        redredis.create(r);
        return String.valueOf(uid);
    }
    @PostMapping("/getmoney")
    public double getMoney(@RequestParam("uid")long uid){
       return red.popmoney(uid);
    }
}
