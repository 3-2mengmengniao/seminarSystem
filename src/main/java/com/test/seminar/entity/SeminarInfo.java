package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class SeminarInfo {
    private BigInteger id;
    private BigInteger courseId;
    private String name;
    private String introduction;
    private int maxGroup;
    private int visible;
    private Date reportDDL;

    public BigInteger getId() {return id; }

    public void setId(BigInteger id) {this.id = id; }

    public BigInteger getCourseId() {return courseId; }

    public void setCourseId(BigInteger courseId) {this.courseId = courseId; }

    public String getName() { return name; }

    public void setName(String name) {this.name = name; }

    public String getIntroduction() {return introduction; }

    public void setIntroduction(String introduction) {this.introduction = introduction; }

    public int getMaxGroup() {return maxGroup; }

    public void setMaxGroup(int maxGroup) { this.maxGroup = maxGroup; }

    public int getVisible() {return visible; }

    public void setVisible(int visible) {this.visible = visible; }

    public Date getReportDDL() {return reportDDL; }

    public void setReportDDL(Date reportDDL) {this.reportDDL = reportDDL; }
}
