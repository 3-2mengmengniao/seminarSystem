package com.test.seminar.mapper;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.CourseClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Mapper
@Component
public interface CourseClassMapper {

    /**
     * 通过ID获取班级信息
     *
     * @param courseClassId
     * @return
     */
    CourseClass getCourseClassByCourseClassId(@Param("courseClassId") BigInteger courseClassId);

    /**
     * 获取某课程下的所有班级
     *
     * @param courseId
     * @return
     */
    List<CourseClass> getCourseClassByCourseId(@Param("courseId")BigInteger courseId);

    /**
     *
     * @param teamId
     * @return
     */
    CourseClass getCourseClassByTeamId(@Param("teamId")BigInteger teamId);

    /**
     * 获取某课程下某学生的班级
     * @param studentId
     * @param courseId
     * @return
     */
    CourseClass getCourseClassByStudentIdAndCourseId(@Param("studentId")BigInteger studentId,@Param("courseId")BigInteger courseId);

    /**
     *
     * @param seminarControlId
     * @return
     */
    CourseClass getCourseClassBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);
    /**
     * 创建新的班级账户
     *
     * @param courseClass
     * @return
     */
    void insertCourseClass(@Param("courseClass")CourseClass courseClass,@Param("courseId")BigInteger courseId);

    /**
     * @param courseClassId
     * @param studentId
     * @param courseId
     * @return
     */
    void insertCourseClassStudentRelation(@Param("courseClassId")BigInteger courseClassId,@Param("studentId")BigInteger studentId,@Param("courseId")BigInteger courseId);

    /**
     * 更改班级信息
     *
     * @param courseClass
     * @return
     */
    void updateCourseClassByCourseClass(@Param("courseClass")CourseClass courseClass);

    /**
     * @param courseClassId
     * @return
     */
    void deleteCourseClassByCourseClassId(@Param("courseClassId")BigInteger courseClassId);

}