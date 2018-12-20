package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseClassDao;
import com.test.seminar.entity.CourseClass;
import com.test.seminar.exception.CourseClassNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.service.CourseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CourseClassServiceImpl implements CourseClassService {
    @Autowired
    private CourseClassDao courseClassDao;
    @Override
    public CourseClass getCourseClassByCourseClassId(BigInteger courseClassId)throws CourseClassNotFoundException {
        return courseClassDao.getCourseClassByCourseClassId(courseClassId);
    }

    @Override
    public void insertCourseClass(CourseClass courseClass)throws RepetitiveRecordException {
        courseClassDao.insertCourseClass(courseClass);
    }

    @Override
    public void updateCourseClassByCourseClass(CourseClass courseClass)throws CourseClassNotFoundException {
        courseClassDao.updateCourseClassByCourseClass(courseClass);
    }

    @Override
    public void deleteCourseClassByCourseClassId(BigInteger courseClassId)throws CourseClassNotFoundException {
        courseClassDao.deleteCourseClassByCourseClassId(courseClassId);
    }

    @Override
    public List<CourseClass> getCourseClassByCourseId(BigInteger courseId) {
        return courseClassDao.getCourseClassByCourseId(courseId);
    }

    @Override
    public CourseClass getCourseClassByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId)throws CourseClassNotFoundException{
        return courseClassDao.getCourseClassByStudentIdAndCourseId(studentId,courseId);
    }

}
