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
    private int status;
    private Integer teamSerial;
    private Student leader;
    private CourseClass courseClass;
    private List<Student> memberList;
    private List<Question> questionList;

    public BigInteger getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Student getLeader() { return leader; }

    public void setLeader(Student leader) { this.leader = leader; }

    public Integer getTeamSerial() {
        return teamSerial;
    }

    public void setTeamSerial(int teamSerial) {
        this.teamSerial = teamSerial;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Question> getQuestionList() { return questionList; }

    public void setQuestionList(List<Question> questionList) { this.questionList = questionList; }

    public List<Student> getMemberList() { return memberList; }

    public void setMemberList(List<Student> memberList) { this.memberList = memberList; }

    public CourseClass getCourseClass() { return courseClass; }

    public void setCourseClass(CourseClass courseClass) { this.courseClass = courseClass; }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Team) {
            Team t = (Team) o;
            return this.id.equals(t.getId());
        }
        return super.equals(o);
    }
}


