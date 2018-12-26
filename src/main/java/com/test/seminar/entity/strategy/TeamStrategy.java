package com.test.seminar.entity.strategy;

import com.test.seminar.entity.Course;

import java.math.BigInteger;

/**
 * 某课程总策略实体
 * @author wzw
 * date 2018/12/25
 */
public class TeamStrategy {
    private Course course;
    private Integer strategySerial;
    private String strategyName;
    private BigInteger strategyId;

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

    public BigInteger getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(BigInteger strategyId) {
        this.strategyId = strategyId;
    }
}
