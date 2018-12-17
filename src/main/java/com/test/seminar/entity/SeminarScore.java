package com.test.seminar.entity;

import java.math.BigInteger;

public class SeminarScore {
    private BigInteger seminarControlId;
    private BigInteger teamId;
    private double totalScore;
    private double presentationScore;
    private double questionScore;
    private double reportScore;

    public BigInteger getSeminarControlId() {
        return seminarControlId;
    }

    public BigInteger getTeamId() {
        return teamId;
    }

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

    public void setSeminarControlId(BigInteger seminarControlId) {
        this.seminarControlId = seminarControlId;
    }

    public void setTeamId(BigInteger teamId) {
        this.teamId = teamId;
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
}
