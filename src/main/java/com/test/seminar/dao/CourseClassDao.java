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
     *
     * @param courseId course id
     * @return List<CourseClass>
     */
    List<CourseClass> getCourseClassByCourseId(BigInteger courseId);

    /**
     * 找到某课程的第serial个班级
     * @param courseId course id
     * @param serial serial
     * @return CourseClass
     */
    CourseClass getCourseClassByCourseIdAndSerial(BigInteger courseId,int serial);


    /**
     * 通过小组id获得班级
     *
     * @param teamId team id
     * @return CourseClass
     */
    CourseClass getCourseClassByTeamId(BigInteger teamId);

    /**
     * 获取某课程下某学生的班级
     *
     * @param studentId student id
     * @param courseId course id
     * @throws CourseClassNotFoundException 找不到班级
     * @return CourseClass
     */
    CourseClass getCourseClassByStudentIdAndCourseId(BigInteger studentId,BigInteger courseId)throws CourseClassNotFoundException;

    /**
     * 通过ID获取班级信息
     * @param courseClassId course class id
     * @throws CourseClassNotFoundException 找不到班级
     * @return CourseClass
     */
    CourseClass getCourseClassByCourseClassId(BigInteger courseClassId) throws CourseClassNotFoundException;

    /**
     * 创建新的班级账户
     *
     * @param courseClass course class
     * @param courseId course id
     * @throws RepetitiveRecordException repetitive record found
     */
    void insertCourseClass(CourseClass courseClass, BigInteger courseId) throws RepetitiveRecordException;

    /**
     * 插入班级学生关系
     *
     * @param courseClassId course class id
     * @param studentId student id
     * @param courseId course id
     */
    void insertCourseClassStudentRelation(BigInteger courseClassId, BigInteger studentId, BigInteger courseId);

    /**
     * 更改班级信息
     * @param courseClass course class
     * @throws CourseClassNotFoundException course class not found
     */
    void updateCourseClassByCourseClass(CourseClass courseClass) throws CourseClassNotFoundException;

    /**
     *通过班级id删除班级
     *
     * @param courseClassId course class id
     * @throws CourseClassNotFoundException course class not found
     */
    void deleteCourseClassByCourseClassId(BigInteger courseClassId) throws CourseClassNotFoundException;

    /**
     * 通过班级id删除班级和小组关系
     *
     * @param courseClassId course class id
     */
    void deleteCourseClassAndTeamRelationByCourseClassId(BigInteger courseClassId);

    /**
     * 获取班级下队伍数
     *
     * @param courseClassId course class id
     * @return Integer
     */
    Integer getCourseClassTeamNumber(BigInteger courseClassId);

    /**
     * 通过小组和课程id获取班级
     *
     * @param teamId team id
     * @param courseId course id
     * @return CourseClass
     */
    CourseClass getCourseClassByTeamIdAndCourseId(BigInteger teamId,BigInteger courseId);
}