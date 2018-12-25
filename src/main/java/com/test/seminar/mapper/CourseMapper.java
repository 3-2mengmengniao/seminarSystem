package com.test.seminar.mapper;

import com.test.seminar.entity.Course;
import com.test.seminar.exception.StrategyNotFoundException;
import com.test.seminar.strategy.impl.ConflictCourseStrategy;
import com.test.seminar.strategy.impl.CourseMemberLimitStrategy;
import com.test.seminar.strategy.impl.MemberLimitStrategy;
import com.test.seminar.strategy.impl.TeamStrategy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author zhenweiwang
 * @date 2018/11/29
 *
 */
@Mapper
@Component
public interface CourseMapper {
    /**
     * 通过ID获取课程信息
     * @param courseId
     * @return
     */
    Course getCourseByCourseId(@Param("courseId")BigInteger courseId);

    /**
     *
     * @param courseClassId
     * @return
     */
    Course getCourseByCourseClassId(@Param("courseClassId")BigInteger courseClassId);

    /**
     * 通过老师ID获取课程列表
     * @param teacherId
     * @return
     */
    List<Course> getCourseByTeacherId(@Param("teacherId")BigInteger teacherId);

    /**
     * 通过学生ID获取课程列表
     * @param studentId
     * @return
     */
    List<Course> getCourseByStudentId(@Param("studentId")BigInteger studentId);

    List<Course> getCourseBySeminarMainCourseId(@Param("seminarMainCourseId")BigInteger seminarMainCourseId);

    List<Course> getCourseByTeamMainCourseId(@Param("teamMainCourseId")BigInteger teamMainCourseId);
    /**
     * 创建新的课程账户
     * @param course
     * @return
     */
    void insertCourse(@Param("course") Course course,@Param("teacherId")BigInteger teacherId);

    /**
     * 更改课程信息
     * @param course
     * @return
     */
    void updateCourseByCourseId(@Param("course")Course course);

    /**
     *
     * @param courseId
     * @return
     */
    void deleteCourseByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 通过课程ID获取课程的分组策略列表
     * @param courseId
     * @return
     */
    List<TeamStrategy> getTeamStrategyListByCourseId(BigInteger courseId);

    /**
     * 通过策略ID获取MemberLimitStrategy
     * @param strategyId
     * @return
     */
    MemberLimitStrategy getMemberLimitStrategyByStrategyId(BigInteger strategyId);

    /**
     * 通过策略ID获取CourseMemberLimitStrategy
     * @param strategyId
     * @return
     */
    CourseMemberLimitStrategy getCourseMemberLimitStrategyByStrategyId(BigInteger strategyId);

    /**
     * 通过策略ID获取ConflictCourseStrategy
     * @param strategyId
     * @return
     */
    ConflictCourseStrategy getConflictCourseStrategyByStrategyId(BigInteger strategyId);
}
