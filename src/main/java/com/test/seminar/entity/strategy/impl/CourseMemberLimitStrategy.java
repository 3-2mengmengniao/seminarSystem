package com.test.seminar.entity.strategy.impl;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.strategy.Strategy;

import java.math.BigInteger;
import java.util.List;

/**
 * @author wzw
 * date 2018/12/25
 */
public class CourseMemberLimitStrategy extends Strategy {
    private BigInteger id;
    private BigInteger courseId;
    private Integer minMember;
    private Integer maxMember;


    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public BigInteger getCourseId() { return courseId; }

    public void setCourseId(BigInteger courseId) { this.courseId = courseId; }

    public Integer getMinMember() {
        return minMember;
    }

    public void setMinMember(Integer minMember) {
        this.minMember = minMember;
    }

    public Integer getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(Integer maxMember) {
        this.maxMember = maxMember;
    }

    @Override
    public Boolean isValid(Team team) {
        List<Student> studentList = team.getMemberList();
        if (studentList == null) {
            return false;
        }

        //队伍中属于该课程的人数
        int count = 0;
        for (Student student : studentList) {
            List<Course> courseList = student.getCourseList();
            for(Course course:courseList){
                if(course.getId().equals(this.courseId)){
                    count++;
                }
            }
        }

        if(minMember!=null){
            if(count<minMember){
                return false;
            }
        }
        if(maxMember!=null){
            if(count>maxMember){
                return false;
            }
        }

        return true;

    }
}
