package com.test.seminar.strategy.impl;

import com.test.seminar.entity.Course;

/**
 * @author wzw
 * date 2018/12/25
 */
public class TeamStrategy {
    private Course course;
    private Integer strategySerial;
    private String strategyName;
    private String strategyId;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getStrategySerial() {
        return strategySerial;
    }

    public void setStrategySerial(int strategySerial) {
        this.strategySerial = strategySerial;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }
}
