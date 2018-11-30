package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Round {
    private BigInteger id;
    private BigInteger courseId;
    private int enrollNumber;
    private int caculateMethod;

    public BigInteger getId() {return id; }

    public void setId(BigInteger id) {this.id = id; }

    public BigInteger getClassId() { return courseId; }

    public void setClassId(BigInteger classId) {this.courseId = classId; }

    public int getEnrollNumber() {return enrollNumber; }

    public void setEnrollNumber(int enrollNumber) {this.enrollNumber = enrollNumber; }

    public int getCaculateMethod() {return caculateMethod; }

    public void setCaculateMethod(int caculateMethod) {this.caculateMethod = caculateMethod; }
}
