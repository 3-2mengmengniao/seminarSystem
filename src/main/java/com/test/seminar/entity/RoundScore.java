package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.List;

public class RoundScore {
    private BigInteger teamId;
    private Serial serial;
    private List<SeminarScore> seminarScoreList;
    private double totalScore;
    private double presentationScore;
    private double questionScore;
    private double reportScore;

    public BigInteger getTeamId() { return teamId; }

    public void setTeamId(BigInteger teamId) { this.teamId = teamId; }

    public double getTotalScore() { return totalScore; }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double getPresentationScore() {
        return presentationScore;
    }

    public void setPresentationScore(double presentationScore) {
        this.presentationScore = presentationScore;
    }

    public double getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(double questionScore) {
        this.questionScore = questionScore;
    }

    public double getReportScore() {
        return reportScore;
    }

    public void setReportScore(double reportScore) {
        this.reportScore = reportScore;
    }

    public Serial getSerial() { return serial; }

    public void setSerial(Serial serial) { this.serial = serial; }

    public List<SeminarScore> getSeminarScoreList() { return seminarScoreList; }

    public void setSeminarScoreList(List<SeminarScore> seminarScoreList) { this.seminarScoreList = seminarScoreList; }
}
