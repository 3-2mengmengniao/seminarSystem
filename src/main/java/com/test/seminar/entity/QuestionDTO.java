package com.test.seminar.entity;

import java.math.BigInteger;

public class QuestionDTO {
    private BigInteger id;
    private BigInteger studentId;
    private String studentName;
    private BigInteger teamId;
    private Integer courseClassSerial;
    private Integer teamSerial;

    public QuestionDTO(Question question) {
        this.id = question.getId();
        this.studentId = question.getStudent().getId();
        this.studentName = question.getStudent().getStudentName();
        this.teamId = question.getTeamId();
        this.courseClassSerial = question.getSerial().getCourseClassSerial();
        this.teamSerial = question.getSerial().getTeamSerial();
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getStudentId() {
        return studentId;
    }

    public void setStudentId(BigInteger studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public BigInteger getTeamId() {
        return teamId;
    }

    public void setTeamId(BigInteger teamId) {
        this.teamId = teamId;
    }

    public Integer getCourseClassSerial() {
        return courseClassSerial;
    }

    public void setCourseClassSerial(Integer courseClassSerial) {
        this.courseClassSerial = courseClassSerial;
    }

    public Integer getTeamSerial() {
        return teamSerial;
    }

    public void setTeamSerial(Integer teamSerial) {
        this.teamSerial = teamSerial;
    }
}
