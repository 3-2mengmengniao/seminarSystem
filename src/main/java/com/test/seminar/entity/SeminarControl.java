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
    private String seminarStatus;

    public BigInteger getId() {
        return id;
    }

    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }

    public BigInteger getSeminarInfoId() {
        return seminarInfoId;
    }

    public void setSeminarInfoId(BigInteger seminarInfoId) {
        this.seminarInfoId = seminarInfoId;
    }

    public String getSeminarStatus() {
        return seminarStatus;
    }

    public void setSeminarStatus(String seminarStatus) {
        this.seminarStatus = seminarStatus;
    }
}
