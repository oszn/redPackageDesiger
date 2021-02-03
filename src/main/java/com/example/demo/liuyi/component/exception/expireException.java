package com.example.demo.liuyi.component.exception;

public class expireException extends RuntimeException{
    public String getEr() {

        return er;
    }

    public void setEr(String er) {
        this.er = er;
    }

    String er;
        public expireException(String s) {
            this.er=s;
        }

}
