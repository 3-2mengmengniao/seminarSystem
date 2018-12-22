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
    private int teamSerial;
    private Student leader;
    private CourseClass courseClass;
    private BigInteger leader_id;
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

    public int getTeamSerial() {
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

    public BigInteger getLeader_id() { return leader_id; }

    public void setLeader_id(BigInteger leader_id) { this.leader_id = leader_id; }
}


