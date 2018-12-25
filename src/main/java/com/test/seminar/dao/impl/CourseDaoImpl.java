package com.test.seminar.dao.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.Course;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.StrategyNotFoundException;
import com.test.seminar.mapper.CourseMapper;
import com.test.seminar.strategy.impl.ConflictCourseStrategy;
import com.test.seminar.strategy.impl.CourseMemberLimitStrategy;
import com.test.seminar.strategy.impl.MemberLimitStrategy;
import com.test.seminar.strategy.impl.TeamStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
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
        return null;
    }

    @Override
    public MemberLimitStrategy getMemberLimitStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        return null;
    }

    @Override
    public CourseMemberLimitStrategy getCourseMemberLimitStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        return null;
    }

    @Override
    public ConflictCourseStrategy getConflictCourseStrategyByStrategyId(BigInteger strategyId) throws StrategyNotFoundException {
        return null;
    }
}