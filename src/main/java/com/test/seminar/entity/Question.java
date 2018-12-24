package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Question {
    private BigInteger teamId;
    private Student student;
    private int selected;
    private double score;

    public BigInteger getTeamId() {
        return teamId;
    }

    public void setTeamId(BigInteger teamId) {
        this.teamId = teamId;
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
}
