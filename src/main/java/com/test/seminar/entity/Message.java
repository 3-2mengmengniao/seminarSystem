package com.test.seminar.entity;

import java.math.BigInteger;
/**
 * @author xmr
 * @date 2018/11/28
 */

public class Message {
    private BigInteger teamId;
    private BigInteger seminarId;
    private BigInteger studentId;

    public BigInteger getStudentId() {
        return studentId;
    }

    public void setStudentId(BigInteger studentId) {
        this.studentId = studentId;
    }

    public BigInteger getTeamId() {
        return teamId;
    }

    public void setTeamId(BigInteger teamId) {
        this.teamId = teamId;
    }

    public BigInteger getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(BigInteger seminarId) {
        this.seminarId = seminarId;
    }
}
