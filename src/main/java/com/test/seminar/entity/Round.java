package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Round {
    private BigInteger id;
    private int roundSerial;
    private int presentationScoreMethod;
    private int reportScoreMethod;
    private int questionScoreMethod;
    private List<SeminarInfo> seminarInfoList;
    private List<RoundScore> roundScoreList;

    public BigInteger getId() { return id; }

    public int getRoundSerial() {
        return roundSerial;
    }

    public void setRoundSerial(int roundSerial) {
        this.roundSerial = roundSerial;
    }

    public int getPresentationScoreMethod() {
        return presentationScoreMethod;
    }

    public void setPresentationScoreMethod(int presentationScoreMethod) { this.presentationScoreMethod = presentationScoreMethod; }

    public int getReportScoreMethod() {
        return reportScoreMethod;
    }

    public void setReportScoreMethod(int reportScoreMethod) {
        this.reportScoreMethod = reportScoreMethod;
    }

    public int getQuestionScoreMethod() {
        return questionScoreMethod;
    }

    public void setQuestionScoreMethod(int questionScoreMethod) {
        this.questionScoreMethod = questionScoreMethod;
    }

    public List<SeminarInfo> getSeminarInfoList() { return seminarInfoList; }

    public void setSeminarInfoList(List<SeminarInfo> seminarInfoList) { this.seminarInfoList = seminarInfoList; }

    public List<RoundScore> getRoundScoreList() { return roundScoreList; }

    public void setRoundScoreList(List<RoundScore> roundScoreList) { this.roundScoreList = roundScoreList; }
}
