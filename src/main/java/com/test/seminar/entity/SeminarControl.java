package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class SeminarControl {
    private BigInteger id;
    private BigInteger classId;
    private BigInteger seminarInfoId;

    public BigInteger getId() {return id; }

    public BigInteger getClassId() {return classId; }

    public void setRoundId(BigInteger roundId) {this.classId = roundId; }

    public BigInteger getSeminarInfoId() {return seminarInfoId; }

    public void setSeminarInfoId(BigInteger seminarInfoId) {this.seminarInfoId = seminarInfoId; }
}
