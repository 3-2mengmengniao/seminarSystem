package com.test.seminar.dao;

import com.test.seminar.entity.CourseClass;
import com.test.seminar.exception.CourseClassNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/28
 */

public interface CourseClassDao {
    /**
     * 获取某课程下的所有班级
     * @param courseId
     * @return
     */
    List<CourseClass> getCourseClassByCourseId(BigInteger courseId);

    /**
     * 找到某课程的第serial个班级
     * @param courseId
     * @param serial
     * @return
     */
    CourseClass getCourseClassByCourseIdAndSerial(BigInteger courseId,int serial);


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

    void deleteCourseClassAndTeamRelationByCourseClassId(BigInteger courseClassId);

    Integer getCourseClassTeamNumber(BigInteger courseClassId);

    CourseClass getCourseClassByTeamIdAndCourseId(BigInteger teamId,BigInteger courseId);
}