package com.test.seminar.entity;

import java.math.BigInteger;

public class SeminarScore {
    private BigInteger teamId;
    private Serial serial;
    private String seminarInfoName;
    private double totalScore;
    private double presentationScore;
    private double questionScore;
    private double reportScore;

    public String getSeminarInfoName() { return seminarInfoName; }

    public void setSeminarInfoName(String seminarInfoName) { this.seminarInfoName = seminarInfoName; }

    public double getTotalScore() {
        return totalScore;
    }

    public double getPresentationScore() {
        return presentationScore;
    }

    public double getQuestionScore() {
        return questionScore;
    }

    public double getReportScore() {
        return reportScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public void setPresentationScore(double presentationScore) {
        this.presentationScore = presentationScore;
    }

    public void setQuestionScore(double questionScore) {
        this.questionScore = questionScore;
    }

    public void setReportScore(double reportScore) {
        this.reportScore = reportScore;
    }

    public BigInteger getTeamId() { return teamId; }

    public void setTeamId(BigInteger teamId) { this.teamId = teamId; }

    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }
}
