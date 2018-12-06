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
    public CourseClass getCourseClassByCourseClassId(BigInteger courseClassId) throws CourseClassNotFoundException {
        CourseClass courseClass=courseClassDao.getCourseClassByCourseClassId(courseClassId);
        if(courseClass==null)
            throw new CourseClassNotFoundException();
        return courseClass;
    }

    @Override
    public void insertCourseClass(CourseClass courseClass) throws RepetitiveRecordException {
        courseClassDao.insertCourseClass(courseClass);
    }

    @Override
    public void updateCourseClassByCourseClassId(CourseClass courseClass) throws CourseClassNotFoundException {
        if(courseClassDao.getCourseClassByCourseClassId(courseClass.getId())==null)
            throw new CourseClassNotFoundException();
        courseClassDao.updateCourseClassByCourseClassId(courseClass);
    }

    @Override
    public void deleteCourseClassByCourseClassId(BigInteger courseClassId) throws CourseClassNotFoundException {
        if(courseClassDao.getCourseClassByCourseClassId(courseClassId)==null)
            throw new CourseClassNotFoundException();
        courseClassDao.deleteCourseClassByCourseClassId(courseClassId);
    }

    @Override
    public List<CourseClass> getCourseClassByCourseId(BigInteger courseId) {
        return courseClassDao.getCourseClassByCourseId(courseId);
    }

    @Override
    public CourseClass getCourseClassByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId){
        CourseClass courseClass=courseClassDao.getCourseClassByStudentIdAndCourseId(studentId,courseId);
        if(courseClass==null)
            throw new CourseClassNotFoundException();
        return courseClass;
    }

}
