package com.test.seminar.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class SeminarInfo {
    private BigInteger id;
    private BigInteger courseId;
    private BigInteger roundId;
    private String seminarName;
    private String introduction;
    private int maxGroup;
    private int visible;
    private Date reportDDL;
    private int seminarSerial;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registrationStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registrationEndTime;


    public BigInteger getId() {
        return id;
    }

    public BigInteger getCourseId() {
        return courseId;
    }

    public void setCourseId(BigInteger courseId) {
        this.courseId = courseId;
    }

    public BigInteger getRoundId() {
        return roundId;
    }

    public void setRoundId(BigInteger roundId) {
        this.roundId = roundId;
    }

    public String getSeminarName() {
        return seminarName;
    }

    public void setSeminarName(String seminarName) {
        this.seminarName = seminarName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getMaxGroup() {
        return maxGroup;
    }

    public void setMaxGroup(int maxGroup) {
        this.maxGroup = maxGroup;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public Date getReportDDL() {
        return reportDDL;
    }

    public void setReportDDL(Date reportDDL) {
        this.reportDDL = reportDDL;
    }

    public int getSeminarSerial() {
        return seminarSerial;
    }

    public void setSeminarSerial(int seminarSerial) {
        this.seminarSerial = seminarSerial;
    }


    public Date getRegistrationStartTime() {
        return registrationStartTime;
    }

    public void setRegistrationStartTime(Date registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
    }

    public Date getRegistrationEndTime() {
        return registrationEndTime;
    }

    public void setRegistrationEndTime(Date registrationEndTime) {
        this.registrationEndTime = registrationEndTime;
    }
}

