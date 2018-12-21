package com.test.seminar.dao.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.Course;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.mapper.CourseMapper;
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
}