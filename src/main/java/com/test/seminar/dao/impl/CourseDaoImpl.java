package com.test.seminar.dao.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.Course;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.StrategyNotFoundException;
import com.test.seminar.mapper.CourseMapper;
import com.test.seminar.strategy.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.SQLTransientException;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class CourseDaoImpl implements CourseDao {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        Course course = courseMapper.getCourseByCourseId(courseId);
        if(course==null) {
            throw new CourseNotFoundException();
        }
        return course;
    }

    @Override
    public List<Course> getCourseByTeacherId(BigInteger teacherId) {
        return courseMapper.getCourseByTeacherId(teacherId);
    }

    @Override
    public List<Course> getCourseByStudentId(BigInteger studentId) {
        return courseMapper.getCourseByStudentId(studentId);
    }

    @Override
    public List<Course> getCourseBySeminarMainCourseId(BigInteger seminarMainCourseId) {
        return courseMapper.getCourseBySeminarMainCourseId(seminarMainCourseId);
    }

    @Override
    public List<Course> getCourseByTeamMainCourseId(BigInteger teamMainCourseId) {
        return courseMapper.getCourseByTeamMainCourseId(teamMainCourseId);
    }

    @Override
    public void insertCourse(Course course,BigInteger teacherId)throws RepetitiveRecordException {
        courseMapper.insertCourse(course,teacherId);
    }

    @Override
    public void updateCourseByCourseId(Course course)throws CourseNotFoundException {
        courseMapper.updateCourseByCourseId(course);
    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId)throws CourseNotFoundException {
        Course course = courseMapper.getCourseByCourseId(courseId);
        if(course==null) {
            throw new CourseNotFoundException();
        }
        courseMapper.deleteCourseByCourseId(courseId);
    }

    @Override
    public List<TeamStrategy> getTeamStrategyListByCourseId(BigInteger courseId) throws StrategyNotFoundException {
        List<TeamStrategy> teamStrategyList=courseMapper.getTeamStrategyListByCourseId(courseId);
        if(teamStrategyList==null){
            throw new StrategyNotFoundException();
        }
        return teamStrategyList;
    }

    @Override
    public MemberLimitStrategy getMemberLimitStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        MemberLimitStrategy memberLimitStrategy=courseMapper.getMemberLimitStrategyByStrategyId(strategyId);
        if(memberLimitStrategy==null){
            throw new StrategyNotFoundException();
        }
        return memberLimitStrategy;
    }

    @Override
    public void updateMemberLimitStrategy(MemberLimitStrategy memberLimitStrategy){
        courseMapper.updateMemberLimitStrategy(memberLimitStrategy);
    }

    @Override
    public void deleteMemberLimitStrategyByStrategyId(BigInteger strategyId){
        courseMapper.deleteMemberLimitStrategyByStrategyId(strategyId);
    }

    @Override
    public CourseMemberLimitStrategy getCourseMemberLimitStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        CourseMemberLimitStrategy courseMemberLimitStrategy=courseMapper.getCourseMemberLimitStrategyByStrategyId(strategyId);
        if(courseMemberLimitStrategy==null){
            throw new StrategyNotFoundException();
        }
        return courseMemberLimitStrategy;
    }

    @Override
    public ConflictCourseStrategy getConflictCourseStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        ConflictCourseStrategy conflictCourseStrategy=courseMapper.getConflictCourseStrategyByStrategyId(strategyId);
        if(conflictCourseStrategy==null){
            throw new StrategyNotFoundException();
        }
        return conflictCourseStrategy;
    }

    @Override
    public TeamAndStrategy getTeamAndStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        TeamAndStrategy teamAndStrategy=courseMapper.getTeamAndStrategyByStrategyId(strategyId);
        if(teamAndStrategy==null){
            throw new StrategyNotFoundException();
        }
        return teamAndStrategy;
    }

    @Override
    public TeamOrStrategy getTeamOrStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        TeamOrStrategy teamOrStrategy=courseMapper.getTeamOrStrategyByStrategyId(strategyId);
        if(teamOrStrategy==null){
            throw new StrategyNotFoundException();
        }
        return teamOrStrategy;
    }
}