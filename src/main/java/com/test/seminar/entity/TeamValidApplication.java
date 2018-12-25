package com.test.seminar.entity;

import java.math.BigInteger;

public class TeamValidApplication {
    private BigInteger id;
    private Team team;
    private String reason;
    private Integer status;

    public BigInteger getId() {
        return id;
    }

    public Team getTeam() { return team; }

    public void setTeam(Team team) { this.team = team; }

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
