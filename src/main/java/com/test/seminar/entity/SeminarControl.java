package com.test.seminar.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class SeminarControl {
    private BigInteger id;
    private BigInteger classId;
    private BigInteger seminarInfoId;
    private int seminarStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportDDL;

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

    public int getSeminarStatus() {
        return seminarStatus;
    }

    public void setSeminarStatus(int seminarStatus) {
        this.seminarStatus = seminarStatus;
    }

    public Date getReportDDL() {
        return reportDDL;
    }

    public void setReportDDL(Date reportDDL) {
        this.reportDDL = reportDDL;
    }
}
