package com.test.seminar.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author zhenweiwang
 * @date 2018/11/26
 */

public class Teacher{
    private BigInteger id;
    private String account;
    private String password;
    private int active;
    private String teacherName;
    private String email;
    private List<Course> courseList;
    private List<ShareSeminarApplication> shareSeminarApplicationsList;
    private List<ShareTeamApplication> shareTeamApplicationList;
    private List<TeamValidApplication> teamValidApplicationList;

    public BigInteger getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourseList() { return courseList; }

    public void setCourseList(List<Course> courseList) { this.courseList = courseList; }

    public List<ShareSeminarApplication> getShareSeminarApplicationsList() { return shareSeminarApplicationsList; }

    public void setShareSeminarApplicationsList(List<ShareSeminarApplication> shareSeminarApplicationsList) { this.shareSeminarApplicationsList = shareSeminarApplicationsList; }

    public List<ShareTeamApplication> getShareTeamApplicationList() { return shareTeamApplicationList; }

    public void setShareTeamApplicationList(List<ShareTeamApplication> shareTeamApplicationList) { this.shareTeamApplicationList = shareTeamApplicationList; }

    public List<TeamValidApplication> getTeamValidApplicationList() { return teamValidApplicationList; }

    public void setTeamValidApplicationList(List<TeamValidApplication> teamValidApplicationList) { this.teamValidApplicationList = teamValidApplicationList; }
}
