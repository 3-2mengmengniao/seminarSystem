package com.test.seminar.entity;

import java.math.BigInteger;

public class TeamValidApplication {
    private BigInteger id;
    private BigInteger teamId;
    private BigInteger teacherId;
    private String reason;
    private int status;

    public BigInteger getId() {
        return id;
    }

    public BigInteger getTeamId() {
        return teamId;
    }

    public void setTeamId(BigInteger teamId) {
        this.teamId = teamId;
    }

    public BigInteger getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(BigInteger teacherId) {
        this.teacherId = teacherId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
