package com.test.seminar.entity.strategy.impl;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.strategy.AbstractStrategy;

import java.math.BigInteger;
import java.util.List;

/**
 * @author wzw
 * date 2018/12/25
 */
public class ConflictCourseStrategy extends AbstractStrategy {
    private BigInteger id;
    private List<BigInteger> conflictCourseIdList;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public List<BigInteger> getConflictCourseIdList() {
        return conflictCourseIdList;
    }

    public void setConflictCourseIdList(List<BigInteger> conflictCourseIdList) {
        this.conflictCourseIdList = conflictCourseIdList;
    }

    @Override
    public Boolean isValid(Team team) {
        List<Student> studentList=team.getMemberList();
        //记录遍历过程中，第一个中选了冲突课程中的某个课程的id的下标
        int temp=0;
        Boolean isFirst=true;
        for(Student student:studentList){
            List<Course> courseList=student.getCourseList();
            for(Course course:courseList){
                if(conflictCourseIdList.contains(course.getId())){
                    if(isFirst){
                        temp=conflictCourseIdList.indexOf(course.getId());
                        isFirst=false;
                    }else{
                        //第二次之后出现选择了冲突课程中的课，且不是同一门（id==temp）,则说明有冲突
                        if(temp!=conflictCourseIdList.indexOf(course.getId())){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
