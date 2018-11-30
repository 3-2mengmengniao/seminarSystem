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
    private int presentationScore;
    private int reportScore;
    private int present;
    private int submitReport;
    private int submitPPT;
    private BigInteger reportId;
    private BigInteger pptId;

    public BigInteger getId() {return id; }

    public BigInteger getSeminarControlId() {return seminarControlId; }

    public void setSeminarControlId(BigInteger seminarControlId) {this.seminarControlId = seminarControlId; }

    public BigInteger getTeamId() {return teamId; }

    public void setTeamId(BigInteger teamId) { this.teamId = teamId; }

    public int getPresentationScore() {return presentationScore; }

    public void setPresentationScore(int presentationScore) {this.presentationScore = presentationScore; }

    public int getReportScore() {return reportScore; }

    public void setReportScore(int reportScore) {this.reportScore = reportScore; }

    public int getPresent() {return present; }

    public void setPresent(int present) {this.present = present; }

    public int getSubmitReport() {return submitReport; }

    public void setSubmitReport(int submitReport) {this.submitReport = submitReport; }

    public int getSubmitPPT() {return submitPPT; }

    public void setSubmitPPT(int submitPPT) {this.submitPPT = submitPPT; }

    public BigInteger getReportId() {return reportId; }

    public void setReportId(BigInteger reportId) { this.reportId = reportId; }

    public BigInteger getPptId() {return pptId; }

    public void setPptId(BigInteger pptId) {this.pptId = pptId; }
}
