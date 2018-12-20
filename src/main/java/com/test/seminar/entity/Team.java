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
    private BigInteger leader_id;
    private List<Student> memberList;
    private List<Question> questionList;
    private List<RoundScore> roundScoreList;
    private List<SeminarScore> seminarScoreList;

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

    public List<RoundScore> getRoundScoreList() { return roundScoreList; }

    public void setRoundScoreList(List<RoundScore> roundScoreList) { this.roundScoreList = roundScoreList; }

    public List<SeminarScore> getSeminarScoreList() { return seminarScoreList; }

    public void setSeminarScoreList(List<SeminarScore> seminarScoreList) { this.seminarScoreList = seminarScoreList; }

    public List<Question> getQuestionList() { return questionList; }

    public void setQuestionList(List<Question> questionList) { this.questionList = questionList; }

    public List<Student> getMemberList() { return memberList; }

    public void setMemberList(List<Student> memberList) { this.memberList = memberList; }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Team) {
            Team t = (Team) o;
            return this.id.equals(t.getId());
        }
        return super.equals(o);
    }
}


