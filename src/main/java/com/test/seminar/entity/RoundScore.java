package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.List;

public class RoundScore {
    private BigInteger teamId;
    private int  courseClassSerial;
    private int teamSerial;
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

    public int getCourseClassSerial() { return courseClassSerial; }

    public void setCourseClassSerial(int courseClassSerial) { this.courseClassSerial = courseClassSerial; }

    public int getTeamSerial() { return teamSerial; }

    public void setTeamSerial(int teamSerial) { this.teamSerial = teamSerial; }

    public List<SeminarScore> getSeminarScoreList() { return seminarScoreList; }

    public void setSeminarScoreList(List<SeminarScore> seminarScoreList) { this.seminarScoreList = seminarScoreList; }
}
