package com.test.seminar.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Course {
    private BigInteger id;
    private String courseName;
    private String introduction;
    private Integer presentationPercentage;
    private Integer questionPercentage;
    private Integer reportPercentage;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date teamStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date teamEndTime;
    private List<Course> teamSubCourseList;
    private List<Course> seminarSubCourseList;
    private List<Round> roundList;
    private BigInteger teamMainCourseId;

    public BigInteger getId() {
        return id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getPresentationPercentage() {
        return presentationPercentage;
    }

    public void setPresentationPercentage(int presentationPercentage) { this.presentationPercentage = presentationPercentage; }

    public int getQuestionPercentage() {
        return questionPercentage;
    }

    public void setQuestionPercentage(int questionPercentage) {
        this.questionPercentage = questionPercentage;
    }

    public int getReportPercentage() {
        return reportPercentage;
    }

    public void setReportPercentage(int reportPercentage) {
        this.reportPercentage = reportPercentage;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getTeamStartTime() {
        return teamStartTime;
    }

    public void setTeamStartTime(Date teamStartTime) {
        this.teamStartTime = teamStartTime;
    }

    public Date getTeamEndTime() {
        return teamEndTime;
    }

    public void setTeamEndTime(Date teamEndTime) {
        this.teamEndTime = teamEndTime;
    }

    public List<Course> getTeamSubCourseList() { return teamSubCourseList; }

    public void setTeamSubCourseList(List<Course> teamSubCourseList) { this.teamSubCourseList = teamSubCourseList; }

    public List<Course> getSeminarSubCourseList() { return seminarSubCourseList; }

    public void setSeminarSubCourseList(List<Course> seminarSubCourseList) { this.seminarSubCourseList = seminarSubCourseList; }

    public List<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }

    public void setPresentationPercentage(Integer presentationPercentage) { this.presentationPercentage = presentationPercentage; }

    public void setQuestionPercentage(Integer questionPercentage) { this.questionPercentage = questionPercentage; }

    public void setReportPercentage(Integer reportPercentage) { this.reportPercentage = reportPercentage; }

    public BigInteger getTeamMainCourseId() { return teamMainCourseId; }

    public void setTeamMainCourseId(BigInteger teamMainCourseId) { this.teamMainCourseId = teamMainCourseId; }
}
