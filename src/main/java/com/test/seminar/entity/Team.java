package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Team {
    private BigInteger id;
    private BigInteger questionId;
    private BigInteger classId;
    private BigInteger courseId;
    private BigInteger presentationId;
    private String name;
    private BigInteger leaderId;
    private int established;

    public BigInteger getId() { return id; }

    public BigInteger getQuestionId() {return questionId; }

    public void setQuestionId(BigInteger questionId) {this.questionId = questionId; }

    public BigInteger getClassId() {return classId; }

    public void setClassId(BigInteger classId) {this.classId = classId; }

    public BigInteger getCourseId() {return courseId; }

    public void setCourseId(BigInteger courseId) {this.courseId = courseId; }

    public BigInteger getPresentationId() {return presentationId; }

    public void setPresentationId(BigInteger presentationId) {this.presentationId = presentationId; }

    public String getName() { return name; }

    public void setName(String name) {this.name = name; }

    public BigInteger getLeaderId() {return leaderId; }

    public void setLeaderId(BigInteger leaderId) {this.leaderId = leaderId; }

    public int getEstablished() { return established; }

    public void setEstablished(int established) {this.established = established; }
}


