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
    private int calculateMethod;
    private int roundSerial;

    public BigInteger getId() {
        return id;
    }

    public BigInteger getCourseId() {
        return courseId;
    }

    public void setClassId(BigInteger classId) {
        this.courseId = classId;
    }

    public int getEnrollNumber() {
        return enrollNumber;
    }

    public void setEnrollNumber(int enrollNumber) {
        this.enrollNumber = enrollNumber;
    }

    public int getCalculateMethod() {
        return calculateMethod;
    }

    public void setCalculateMethod(int calculateMethod) {
        this.calculateMethod = calculateMethod;
    }

    public int getRoundSerial() {
        return roundSerial;
    }

    public void setRoundSerial(int roundSerial) {
        this.roundSerial = roundSerial;
    }
}
