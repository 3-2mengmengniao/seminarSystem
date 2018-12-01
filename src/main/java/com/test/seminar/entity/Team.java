package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Team {
    private BigInteger id;
    private BigInteger classId;
    private BigInteger courseId;
    private String teamName;
    private BigInteger leaderId;
    private int established;

    public BigInteger getId() { return id; }

    public void setId(BigInteger id) {this.id = id; }

    public BigInteger getClassId() {return classId; }

    public void setClassId(BigInteger classId) {this.classId = classId; }

    public BigInteger getCourseId() {return courseId; }

    public void setCourseId(BigInteger courseId) {this.courseId = courseId; }

    public String getTeamName() { return teamName; }

    public void setTeamName(String teamName) {this.teamName = teamName; }

    public BigInteger getLeaderId() {return leaderId; }

    public void setLeaderId(BigInteger leaderId) {this.leaderId = leaderId; }

    public int getEstablished() { return established; }

    public void setEstablished(int established) {this.established = established; }
}


