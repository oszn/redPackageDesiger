package com.example.demo.liuyi.component.tools;

import com.example.demo.liuyi.dao.BaseRedPackage;
import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;

public abstract class LinerStruct {
    public ArrayList<Object> list;
    public abstract Object pop();
    public abstract void push(Object val);
    public int size(){
        return list.size();
    }
}
