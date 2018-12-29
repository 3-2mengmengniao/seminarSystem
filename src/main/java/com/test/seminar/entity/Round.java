package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Round {
    private BigInteger id;
    private Integer roundSerial;
    private Integer presentationScoreMethod;
    private Integer reportScoreMethod;
    private Integer questionScoreMethod;
    private List<SeminarInfo> seminarInfoList;
    private List<RoundScore> roundScoreList;
    private List<CourseClassRound> courseClassRoundList;

    public Round() {
        presentationScoreMethod=0;
        reportScoreMethod=0;
        questionScoreMethod=0;
    }

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

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setRoundSerial(Integer roundSerial) {
        this.roundSerial = roundSerial;
    }

    public void setPresentationScoreMethod(Integer presentationScoreMethod) {
        this.presentationScoreMethod = presentationScoreMethod;
    }

    public void setReportScoreMethod(Integer reportScoreMethod) {
        this.reportScoreMethod = reportScoreMethod;
    }

    public void setQuestionScoreMethod(Integer questionScoreMethod) {
        this.questionScoreMethod = questionScoreMethod;
    }

    public List<CourseClassRound> getCourseClassRoundList() {
        return courseClassRoundList;
    }

    public void setCourseClassRoundList(List<CourseClassRound> courseClassRoundList) {
        this.courseClassRoundList = courseClassRoundList;
    }
}
