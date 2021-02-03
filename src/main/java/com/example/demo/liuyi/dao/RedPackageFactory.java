package com.example.demo.liuyi.dao;

public abstract class RedPackageFactory extends BaseRedPackage {
    public abstract void distribution();
    public abstract void create();
    public abstract double pop();
    public abstract void put();
    //    public abstract boolean isExpire();
    public abstract void clear();
    public abstract boolean isEmpty();
}
