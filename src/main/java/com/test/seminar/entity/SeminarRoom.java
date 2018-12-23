package com.test.seminar.entity;

import java.math.BigInteger;

public class SeminarRoom {

    private Integer count;

    public SeminarRoom() {
        this.count = 0;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void incCount(){
        count++;
    }

    public void setCountZero(){
        count=0;
    }
}
