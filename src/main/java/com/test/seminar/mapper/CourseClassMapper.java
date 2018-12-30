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
     * @param courseClassId course class id
     * @return CourseClass
     */
    CourseClass getCourseClassByCourseClassId(@Param("courseClassId") BigInteger courseClassId);

    /**
     * 获取某课程下的所有班级
     *
     * @param courseId course id
     * @return List<CourseClass>
     */
    List<CourseClass> getCourseClassByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 找到某课程的第serial个班级
     * @param courseId course id
     * @param serial serial
     * @return CourseClass
     */
    CourseClass getCourseClassByCourseIdAndSerial(@Param("courseId")BigInteger courseId,@Param("serial")int serial);

    /**
     *通过小组id获得班级
     *
     * @param teamId team id
     * @return CourseClass
     */
    CourseClass getCourseClassByTeamId(@Param("teamId")BigInteger teamId);

    /**
     * 获取某课程下某学生的班级
     * @param studentId student id
     * @param courseId course id
     * @return CourseClass
     */
    CourseClass getCourseClassByStudentIdAndCourseId(@Param("studentId")BigInteger studentId,@Param("courseId")BigInteger courseId);

    /**
     *通过班级讨论课id获取班级
     *
     * @param seminarControlId seminar control id
     * @return CourseClass
     */
    CourseClass getCourseClassBySeminarControlId(@Param("seminarControlId")BigInteger seminarControlId);

    /**
     * 获得某班级下的队伍数量
     * @param courseClassId course class id
     * @return Integer
     */
    Integer getCourseClassTeamNumber(@Param("courseClassId")BigInteger courseClassId);

    /**
     * 创建新的班级账户
     *
     * @param courseClass course class
     * @param courseId course id
     */
    void insertCourseClass(@Param("courseClass")CourseClass courseClass,@Param("courseId")BigInteger courseId);

    /**
     * 插入班级学生关系
     *
     * @param courseClassId course class id
     * @param studentId student id
     * @param courseId course id
     */
    void insertCourseClassStudentRelation(@Param("courseClassId")BigInteger courseClassId,@Param("studentId")BigInteger studentId,@Param("courseId")BigInteger courseId);

    /**
     * 更改班级信息
     *
     * @param courseClass course class
     */
    void updateCourseClassByCourseClass(@Param("courseClass")CourseClass courseClass);

    /**
     * 通过班级id删除班级
     *
     * @param courseClassId course class id
     */
    void deleteCourseClassByCourseClassId(@Param("courseClassId")BigInteger courseClassId);

    /**
     * 通过班级id删除班级和team关系
     *
     * @param courseClassId course class id
     */
    void deleteCourseClassAndTeamRelationByCourseClassId(@Param("courseClassId")BigInteger courseClassId);

    /**
     * 通过课程和小组id获得班级
     *
     * @param teamId team id
     * @param courseId course id
     * @return CourseClass
     */
    CourseClass getCourseClassByTeamIdAndCourseId(@Param("teamId")BigInteger teamId,@Param("courseId")BigInteger courseId);
}