package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Question {
    private BigInteger id;
    private BigInteger seminarControlId;
    private BigInteger presentationId;
    private BigInteger teamId;
    private BigInteger studentId;
    private Student student;
    private Integer selected;
    private double score;
    private Serial serial;

    public Question() {
        selected=0;
    }

    public BigInteger getId() {
        return id;
    }

    public Student getStudent() { return student; }

    public void setStudent(Student student) { this.student = student; }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getSeminarControlId() {
        return seminarControlId;
    }

    public void setSeminarControlId(BigInteger seminarControlId) {
        this.seminarControlId = seminarControlId;
    }

    public BigInteger getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(BigInteger presentationId) {
        this.presentationId = presentationId;
    }

    public BigInteger getTeamId() {
        return teamId;
    }

    public void setTeamId(BigInteger teamId) {
        this.teamId = teamId;
    }

    public BigInteger getStudentId() {
        return studentId;
    }

    public void setStudentId(BigInteger studentId) {
        this.studentId = studentId;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }
}
