package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class CourseClass {
    private BigInteger id;
    private BigInteger courseId;
    private int grade;
    private int classSerial;
    private String introduction;

    public BigInteger getId() {return id; }

    public BigInteger getCourseId() {return courseId; }

    public void setCourseId(BigInteger courseId) {this.courseId = courseId; }

    public String getIntroduction() {return introduction; }

    public void setIntroduction(String introduction) {this.introduction = introduction; }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassSerial() {
        return classSerial;
    }

    public void setClassSerial(int classSerial) {
        this.classSerial = classSerial;
    }
}
