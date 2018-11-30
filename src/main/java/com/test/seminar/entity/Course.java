package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Course {
    private BigInteger id;
    private BigInteger teacherId;
    private String introduction;
    private int presentationProportion;
    private int questionProportion;
    private int reportProportion;
    private String name;
    private int minTeamMember;
    private int maxTeamMember;
    private Date teamStartTime;
    private Date teamEndTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getTeacherId() {
        return teacherId;
    }

    public String getIntroduction() {return introduction; }

    public void setIntroduction(String introduction) {this.introduction=introduction; }

    public int getPresentationProportion() {return presentationProportion; }

    public void setPresentationProportion(int presentationProportion) {this.presentationProportion=presentationProportion; }

    public int getQuestionProportion() {return questionProportion; }

    public void setQuestionProportion(int questionProportion) {this.questionProportion=questionProportion; }

    public int getReportProportion() {return reportProportion; }

    public void setReportProportion(int reportProportion) {this.reportProportion=reportProportion; }

    public String getName() {return name; }

    public void setName(String name) {this.name = name; }

    public int getMinTeamMember() {return minTeamMember; }

    public void setMinTeamMember(int minTeamMember) { this.minTeamMember = minTeamMember; }

    public int getMaxTeamMember() {return maxTeamMember; }

    public void setMaxTeamMember(int maxTeamMember) {this.maxTeamMember = maxTeamMember; }

    public Date getTeamStartTime() {return teamStartTime; }

    public void setTeamStartTime(Date teamStartTime) {this.teamStartTime = teamStartTime; }

    public Date getTeamEndTime() {return teamEndTime; }

    public void setTeamEndTime(Date teamEndTime) {this.teamEndTime = teamEndTime; }
}
