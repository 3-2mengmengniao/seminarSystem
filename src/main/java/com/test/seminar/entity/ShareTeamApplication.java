package com.test.seminar.entity;

import java.math.BigInteger;

public class ShareTeamApplication {
    private BigInteger id;
    private Course mainCourse;
    private Course subCourse;
    private Integer status;

    public BigInteger getId() {
        return id;
    }

    public Course getMainCourse() { return mainCourse; }

    public void setMainCourse(Course mainCourse) { this.mainCourse = mainCourse; }

    public Course getSubCourse() { return subCourse; }

    public void setSubCourse(Course subCourse) { this.subCourse = subCourse; }

    public int getStatus() { return status; }

    public void setStatus(int status) {
        this.status = status;
    }
}
