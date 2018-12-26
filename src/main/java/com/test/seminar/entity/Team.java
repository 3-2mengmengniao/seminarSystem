package com.test.seminar.entity;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyingzhu
 * @date 2018/11/28
 */

public class Team {
    private BigInteger id;
    private String teamName;
    private Integer status;
    private Serial serial;
    private Student leader;
    private Course course;
    private CourseClass courseClass;
    private List<Student> memberList;
    private List<Question> questionList;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Student> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Student> memberList) {
        this.memberList = memberList;
    }

    public Course getCourse() {
        return course;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Team) {
            Team t = (Team) o;
            return this.id.equals(t.getId());
        }
        return super.equals(o);
    }
}


