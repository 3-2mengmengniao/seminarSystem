package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class CourseClass {
    private BigInteger id;
    private BigInteger courseId;
    private String name;
    private String introduction;

    public BigInteger getId() {return id; }

    public void setId(BigInteger id) {this.id = id; }

    public BigInteger getCourseId() {return courseId; }

    public void setCourseId(BigInteger courseId) {this.courseId = courseId; }

    public String getName() {return name; }

    public void setName(String name) {this.name = name; }

    public String getIntroduction() {return introduction; }

    public void setIntroduction(String introduction) {this.introduction = introduction; }
}
