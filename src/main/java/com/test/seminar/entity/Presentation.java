package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Presentation {
    private BigInteger id;
    private BigInteger seminarControlId;
    private BigInteger teamId;
    private int teamOrder;
    private int present;
    private String reportName;
    private String reportUrl;
    private String pptName;
    private String pptUrl;

    public BigInteger getId() {return id; }

    public BigInteger getSeminarControlId() {return seminarControlId; }

    public void setSeminarControlId(BigInteger seminarControlId) {this.seminarControlId = seminarControlId; }

    public BigInteger getTeamId() {return teamId; }

    public void setTeamId(BigInteger teamId) { this.teamId = teamId; }

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
