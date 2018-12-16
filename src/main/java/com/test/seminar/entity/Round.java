package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Round {
    private BigInteger id;
    private BigInteger courseId;
    private int roundSerial;
    private int presentationScoreMethod;
    private int reportScoreMethod;
    private int questionScoreMethod;


    public BigInteger getId() {
        return id;
    }

    public BigInteger getCourseId() {
        return courseId;
    }

    public void setClassId(BigInteger classId) {
        this.courseId = classId;
    }

    public int getRoundSerial() {
        return roundSerial;
    }

    public void setRoundSerial(int roundSerial) {
        this.roundSerial = roundSerial;
    }

    public void setCourseId(BigInteger courseId) {
        this.courseId = courseId;
    }

    public int getPresentationScoreMethod() {
        return presentationScoreMethod;
    }

    public void setPresentationScoreMethod(int presentationScoreMethod) {
        this.presentationScoreMethod = presentationScoreMethod;
    }

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
}
