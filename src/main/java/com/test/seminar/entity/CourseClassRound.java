package com.test.seminar.entity;

import java.math.BigInteger;

/**
 * @author cxh
 * @date 2018/11/28
 */

public class CourseClassRound {
    private BigInteger courseClassId;
    private Integer enrollNumber;

    public BigInteger getCourseClassId() {
        return courseClassId;
    }

    public void setCourseClassId(BigInteger courseClassId) {
        this.courseClassId = courseClassId;
    }

    public Integer getEnrollNumber() {
        return enrollNumber;
    }

    public void setEnrollNumber(Integer enrollNumber) {
        this.enrollNumber = enrollNumber;
    }
}
