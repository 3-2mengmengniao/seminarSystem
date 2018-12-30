package com.test.seminar.entity.strategy.impl;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.strategy.AbstractStrategy;

import java.math.BigInteger;
import java.util.List;

/**
 * @author wzw
 * date 2018/12/25
 */
public class MemberLimitStrategy extends AbstractStrategy {
    private BigInteger id;
    private Integer minMember;
    private Integer maxMember;

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

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

        int size = studentList.size();
        if(minMember!=null){
            if(size<minMember){
                return false;
            }
        }
        if(maxMember!=null){
            if(size>maxMember){
                return false;
            }
        }

        return true;
    }
}
