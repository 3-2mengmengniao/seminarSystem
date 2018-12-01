package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Question {
    private BigInteger id;
    private BigInteger teamId;
    private BigInteger presentationId;
    private BigInteger studentId;
    private BigInteger seminarControlId;
    private int selected;

    public BigInteger getId() {
        return id;
    }

    public BigInteger getTeamId() {
        return teamId;
    }

    public void setTeamId(BigInteger teamId) {
        this.teamId = teamId;
    }

    public BigInteger getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(BigInteger presentationId) {
        this.presentationId = presentationId;
    }

    public BigInteger getStudentId() {
        return studentId;
    }

    public void setStudentId(BigInteger studentId) {
        this.studentId = studentId;
    }

    public BigInteger getSeminarControlId() {
        return seminarControlId;
    }

    public void setSeminarControlId(BigInteger seminarControlId) {
        this.seminarControlId = seminarControlId;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
