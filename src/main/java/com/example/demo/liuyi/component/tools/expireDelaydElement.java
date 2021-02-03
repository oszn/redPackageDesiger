package com.example.demo.liuyi.component.tools;

import com.example.demo.liuyi.dao.BaseRedPackage;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class expireDelaydElement implements Delayed {
    public BaseRedPackage getBrd() {
        return brd;
    }

    public void setBrd(BaseRedPackage brd) {
        this.brd = brd;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    private BaseRedPackage brd;


    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((brd.getExpire()+brd.getDate()) - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        expireDelaydElement w= (expireDelaydElement) o;
        return (int) (this.getDelay(timeUnit)-w.getDelay(w.timeUnit));
    }
}
