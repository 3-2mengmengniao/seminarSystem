package com.test.seminar.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class SeminarControl {
    private BigInteger id;
    private int seminarStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportDDL;
    private SeminarInfo seminarInfo;
    private List<Presentation> presentationList;
    private List<Question> questionList;
    private CourseClass courseClass;
    private List<SeminarScore> seminarScoreList;
    private Round round;

    public BigInteger getId() {
        return id;
    }

    public int getSeminarStatus() {
        return seminarStatus;
    }

    public void setSeminarStatus(int seminarStatus) {
        this.seminarStatus = seminarStatus;
    }

    public Date getReportDDL() {
        return reportDDL;
    }

    public void setReportDDL(Date reportDDL) {
        this.reportDDL = reportDDL;
    }

    public SeminarInfo getSeminarInfo() {
        return seminarInfo;
    }

    public void setSeminarInfo(SeminarInfo seminarInfo) {
        this.seminarInfo = seminarInfo;
    }

    public List<Presentation> getPresentationList() { return presentationList; }

    public void setPresentationList(List<Presentation> presentationList) { this.presentationList = presentationList; }

    public List<Question> getQuestionList() { return questionList; }

    public void setQuestionList(List<Question> questionList) { this.questionList = questionList; }

    public CourseClass getCourseClass() { return courseClass; }

    public void setCourseClass(CourseClass courseClass) { this.courseClass = courseClass; }

    public List<SeminarScore> getSeminarScoreList() { return seminarScoreList; }

    public void setSeminarScoreList(List<SeminarScore> seminarScoreList) { this.seminarScoreList = seminarScoreList; }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}
