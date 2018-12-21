package com.test.seminar.dao;

import com.test.seminar.entity.CourseClass;
import com.test.seminar.exception.CourseClassNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;

import java.math.BigInteger;
import java.util.List;

public interface CourseClassDao {

    /**
     * 通过ID获取班级信息
     * @param courseClassId
     * @throws CourseClassNotFoundException 找不到班级
     * @return
     */
    CourseClass getCourseClassByCourseClassId(BigInteger courseClassId) throws CourseClassNotFoundException;

    /**
     * 创建新的班级账户
     * @param courseClass
     * @throws RepetitiveRecordException
     * @return
     */
    void insertCourseClass(CourseClass courseClass, BigInteger courseId) throws RepetitiveRecordException;

    /**
     * @param courseClassId
     * @param studentId
     * @return
     */
    void insertCourseClassStudentRelation(BigInteger courseClassId, BigInteger studentId, BigInteger courseId);

    /**
     * 更改班级信息
     * @param courseClass
     * @throws CourseClassNotFoundException
     * @return
     */
    void updateCourseClassByCourseClass(CourseClass courseClass) throws CourseClassNotFoundException;

    /**
     *
     * @param courseClassId
     * @throws CourseClassNotFoundException
     * @return
     */
    void deleteCourseClassByCourseClassId(BigInteger courseClassId) throws CourseClassNotFoundException;
}