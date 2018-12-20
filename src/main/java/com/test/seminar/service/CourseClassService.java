package com.test.seminar.service;

import com.test.seminar.entity.CourseClass;
import com.test.seminar.exception.CourseClassNotFoundException;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface CourseClassService {

    /**
     * 获取班级
     * @param courseClassId
     * @return
     */
    CourseClass getCourseClassByCourseClassId(BigInteger courseClassId)throws CourseClassNotFoundException;


    /**
     * 添加班级
     * @param courseClass
     */
    void insertCourseClass(CourseClass courseClass)throws RepetitiveRecordException;


    /**
     * 更新班级
     * @param courseClass
     */
    void updateCourseClassByCourseClass( CourseClass courseClass) throws CourseClassNotFoundException;


    /**
     * 删除班级
     * @param courseClassId
     */
    void deleteCourseClassByCourseClassId(BigInteger courseClassId)throws CourseClassNotFoundException;


    /**
     * 获取某课程下的所有班级
     * @param courseId
     * @return 班级列表
     */
    List<CourseClass> getCourseClassByCourseId(BigInteger courseId);

    CourseClass getCourseClassByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId)throws CourseClassNotFoundException;
}
