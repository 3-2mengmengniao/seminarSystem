package com.test.seminar.entity;

import java.math.BigInteger;

public class SeminarScore {
    private BigInteger teamId;
    private Serial serial;
    private String seminarInfoName;
    private Double totalScore;
    private Double presentationScore;
    private Double questionScore;
    private Double reportScore;

    public SeminarScore() {
        totalScore=Double.valueOf(0);
        presentationScore=Double.valueOf(0);
        questionScore=Double.valueOf(0);
        reportScore=Double.valueOf(0);
    }

    public String getSeminarInfoName() { return seminarInfoName; }

    public void setSeminarInfoName(String seminarInfoName) { this.seminarInfoName = seminarInfoName; }

    public Double getTotalScore() { return totalScore; }

    public void setTotalScore(Double totalScore) { this.totalScore = totalScore; }

    public Double getPresentationScore() { return presentationScore; }

    public void setPresentationScore(Double presentationScore) { this.presentationScore = presentationScore; }

    public Double getQuestionScore() { return questionScore; }

    public void setQuestionScore(Double questionScore) { this.questionScore = questionScore; }

    public Double getReportScore() { return reportScore; }

    public void setReportScore(Double reportScore) { this.reportScore = reportScore; }

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
