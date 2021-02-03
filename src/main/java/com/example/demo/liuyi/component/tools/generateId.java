package com.example.demo.liuyi.component.tools;

public class generateId {
    public static long fromtime(int uid){
        long date=System.currentTimeMillis();
        date=date<<16;
        date+=uid;
        return date;
    }
}
