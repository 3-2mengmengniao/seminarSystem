package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.Course;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws CourseNotFoundException{
        return courseDao.getCourseByCourseId(courseId);
    }

    @Override
    public List<Course> getCourseByTeacherId(BigInteger teacherId) {
        return courseDao.getCourseByTeacherId(teacherId);
    }

    @Override
    public List<Course> getCourseByStudentId(BigInteger studentId) {
        return courseDao.getCourseByStudentId(studentId);
    }

    @Override
    public void insertCourse(Course course) throws RepetitiveRecordException {
        courseDao.insertCourse(course);
    }

    @Override
    public void updateCourseByCourseId(Course course) throws CourseNotFoundException {
        courseDao.updateCourseByCourseId(course);
    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        courseDao.deleteCourseByCourseId(courseId);
    }
}
