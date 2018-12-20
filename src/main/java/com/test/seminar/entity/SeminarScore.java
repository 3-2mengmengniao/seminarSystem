package com.test.seminar.entity;

import java.math.BigInteger;

public class SeminarScore {
    private BigInteger id;
    private double totalScore;
    private double presentationScore;
    private double questionScore;
    private double reportScore;

    public BigInteger getId() { return id; }

    public void setId(BigInteger id) { this.id = id; }

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
}
