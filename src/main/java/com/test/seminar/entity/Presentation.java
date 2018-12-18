package com.test.seminar.entity;

import com.sun.tools.javac.util.List;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Presentation {
    private BigInteger id;
    private Team team;
    private List<Question> questionList;
    private int teamOrder;
    private int present;
    private String reportName;
    private String reportUrl;
    private String pptName;
    private String pptUrl;

    public BigInteger getId() {return id; }

    public Team getTeam() { return team; }

    public void setTeam(Team team) { this.team = team; }

    public List<Question> getQuestionList() { return questionList; }

    public void setQuestionList(List<Question> questionList) { this.questionList = questionList; }

    public int getPresent() {return present; }

    public void setPresent(int present) {this.present = present; }

    public int getTeamOrder() {
        return teamOrder;
    }

    public void setTeamOrder(int teamOrder) {
        this.teamOrder = teamOrder;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getPptName() {
        return pptName;
    }

    public void setPptName(String pptName) {
        this.pptName = pptName;
    }

    public String getPptUrl() {
        return pptUrl;
    }

    public void setPptUrl(String pptUrl) {
        this.pptUrl = pptUrl;
    }
}
