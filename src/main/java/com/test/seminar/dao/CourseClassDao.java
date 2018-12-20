package com.test.seminar.dao;

import com.test.seminar.entity.CourseClass;
import com.test.seminar.exception.CourseClassNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;

import java.math.BigInteger;
import java.util.List;

public interface CourseClassDao {
    /**
     * 获取某课程下的所有班级
     * @param courseId
     * @return
     */
    List<CourseClass> getCourseClassByCourseId(BigInteger courseId);

    /**
     *
     * @param teamId
     * @return
     */
    CourseClass getCourseClassByTeamId(BigInteger teamId);

    /**
     * 获取某课程下某学生的班级
     * @param studentId
     * @param courseId
     * @return
     */
    CourseClass getCourseClassByStudentIdAndCourseId(BigInteger studentId,BigInteger courseId)throws CourseClassNotFoundException;

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