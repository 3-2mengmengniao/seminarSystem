package com.test.seminar.strategy.impl;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Team;
import com.test.seminar.strategy.Strategy;
import java.util.List;

/**
 * @author wzw
 * date 2018/12/25
 */
public class MemberLimitStrategy implements Strategy {
    private int id;
    private int minMember;
    private int maxMember;

    public int getId() {
        return id;
    }

    public int getMinMember() {
        return minMember;
    }

    public void setMinMember(int minMember) {
        this.minMember = minMember;
    }

    public int getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(int maxMember) {
        this.maxMember = maxMember;
    }

    @Override
    public Boolean isValid(Team team) {
        List<Student> studentList = team.getMemberList();
        if (studentList == null) {
            return false;
        }

        int size = studentList.size();
        if (size >= minMember && size <= maxMember) {
            return true;
        } else {
            return false;
        }
    }
}
