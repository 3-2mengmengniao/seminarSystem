package com.test.seminar.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Course {
    private BigInteger id;
    private BigInteger teacherId;
    private String courseName;
    private String introduction;
    private int presentationPercentage;
    private int questionPercentage;
    private int reportPercentage;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date teamStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date teamEndTime;
    private BigInteger teamMainCourseId;
    private BigInteger seminarMainCourseId;

    public BigInteger getId() {
        return id;
    }
    public BigInteger getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(BigInteger teacherId) {
        this.teacherId = teacherId;
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

    public void setPresentationPercentage(int presentationPercentage) {
        this.presentationPercentage = presentationPercentage;
    }

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

    public BigInteger getTeamMainCourseId() {
        return teamMainCourseId;
    }

    public void setTeamMainCourseId(BigInteger teamMainCourseId) {
        this.teamMainCourseId = teamMainCourseId;
    }

    public BigInteger getSeminarMainCourseId() {
        return seminarMainCourseId;
    }

    public void setSeminarMainCourseId(BigInteger seminarMainCourseId) {
        this.seminarMainCourseId = seminarMainCourseId;
    }
}
