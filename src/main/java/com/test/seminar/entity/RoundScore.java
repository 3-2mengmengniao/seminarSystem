package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.List;

public class RoundScore {
    private BigInteger teamId;
    private Serial serial;
    private List<SeminarScore> seminarScoreList;
    private Double totalScore;
    private Double presentationScore;
    private Double questionScore;
    private Double reportScore;

    public BigInteger getTeamId() { return teamId; }

    public void setTeamId(BigInteger teamId) { this.teamId = teamId; }

    public Double getTotalScore() { return totalScore; }

    public void setTotalScore(Double totalScore) { this.totalScore = totalScore; }

    public Double getPresentationScore() { return presentationScore; }

    public void setPresentationScore(Double presentationScore) { this.presentationScore = presentationScore; }

    public Double getQuestionScore() { return questionScore; }

    public void setQuestionScore(Double questionScore) { this.questionScore = questionScore; }

    public Double getReportScore() { return reportScore; }

    public void setReportScore(Double reportScore) { this.reportScore = reportScore; }

    public Serial getSerial() { return serial; }

    public void setSerial(Serial serial) { this.serial = serial; }

    public List<SeminarScore> getSeminarScoreList() { return seminarScoreList; }

    public void setSeminarScoreList(List<SeminarScore> seminarScoreList) { this.seminarScoreList = seminarScoreList; }
}
