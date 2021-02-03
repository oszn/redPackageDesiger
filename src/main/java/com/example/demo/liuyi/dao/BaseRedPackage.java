package com.example.demo.liuyi.dao;

import com.example.demo.liuyi.dao.entry.RedPackageDo;
import com.google.common.util.concurrent.AtomicDouble;

public  class BaseRedPackage {
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public AtomicDouble getMoney() {
        return money;
    }

    public void setMoney(AtomicDouble money) {
        this.money = money;
    }

    public AtomicDouble getOrimoney() {
        return orimoney;
    }

    public void setOrimoney(AtomicDouble orimoney) {
        this.orimoney = orimoney;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
    private long userid;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    private int number;
    private AtomicDouble money;
    private AtomicDouble orimoney;
    private long expire;
    private long uid;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    private long date;
    public RedPackageDo convert(){
            RedPackageDo redDO=new RedPackageDo();
            redDO.setId(this.uid);
            redDO.setUid(this.userid);
            redDO.setDivid(this.number);
            redDO.setExpire(60*1000);
            redDO.setMoney(this.money.doubleValue());
            redDO.setDate(this.date);
            redDO.setExpire(this.expire);
            return redDO;
    }

}
