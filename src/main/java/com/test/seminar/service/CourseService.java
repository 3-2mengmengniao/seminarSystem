package com.test.seminar.service;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.ShareSeminarApplication;
import com.test.seminar.entity.ShareTeamApplication;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.strategy.impl.ConflictCourseStrategy;
import com.test.seminar.entity.strategy.impl.CourseMemberLimitStrategy;
import com.test.seminar.entity.strategy.impl.MemberLimitStrategy;
import com.test.seminar.exception.*;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface CourseService {

    /**
     * 通过ID获取课程信息
     * @param courseId course id
     * @return Course
     * @throws CourseNotFoundException course not found
     */
    Course getCourseByCourseId(BigInteger courseId)throws CourseNotFoundException;

    /**
     * 通过老师ID获取课程列表
     * @param teacherId teacher id
     * @return List<Course>
     */
    List<Course> getCourseByTeacherId(BigInteger teacherId);

    /**
     * 通过学生ID获取课程列表
     * @param studentId student id
     * @return List<Course>
     */
    List<Course> getCourseByStudentId(BigInteger studentId);

    /**
     * 插入课程
     *
     * @param course course
     * @param teacherId teacher id
     * @param conflictCourseStrategyArrayList conflict course strategy array
     * @param courseMemberLimitStrategyList course member limit strategy list
     * @param thisCourse this course
     * @param choose choose
     * @throws RepetitiveRecordException repetitive record found
     */
    void insertCourse(Course course, BigInteger teacherId, List<ConflictCourseStrategy> conflictCourseStrategyArrayList, List<CourseMemberLimitStrategy> courseMemberLimitStrategyList, MemberLimitStrategy thisCourse,Integer choose)throws RepetitiveRecordException;

    /**
     * 更改课程信息
     * @param course course
     * @throws CourseNotFoundException course not found
     */
    void updateCourse(Course course)throws CourseNotFoundException;

    /**
     * 删除课程
     * @param courseId course id
     * @throws CourseNotFoundException course not found
     */
    void deleteCourseByCourseId(BigInteger courseId)throws CourseNotFoundException;

    /**
     * 发送共享讨论课请求
     * @param mainCourseId main course id
     * @param subCourseId sub course id
     * @param subCourseTeacherId sub course teacher id
     */
    void insertShareSeminarApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId);

    /**
     * 通过从课程教师id查看共享讨论课请求
     * @param subCourseTeacherId sub course teacher id
     * @return List<ShareSeminarApplication>
     */
    List<ShareSeminarApplication> getShareSeminarApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId);

    /**
     * 发送共享讨论课请求
     * @param mainCourseId main course id
     * @param subCourseId sub course id
     * @param subCourseTeacherId sub course teacher id
     */
    void insertShareTeamApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId);

    /**
     * 通过从课程教师id查看共享分组请求
     * @param subCourseTeacherId sub course teacher id
     * @return List<ShareTeamApplication>
     * @throws ShareTeamApplicationNotFoundException share team application not found
     */
    List<ShareTeamApplication> getShareTeamApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId) throws ShareTeamApplicationNotFoundException;

    /**
     * 获取系统中所有课程
     * @return List<Course>
     */
    List<Course> getAllCourse();

    /**
     * 获取可用于共享的课程
     *
     * @param courseId course id
     * @return List<Course>
     */
    List<Course> getAvailableCourseForShare(BigInteger courseId);

    /**
     * 通过请求id获取共享组队请求
     *
     * @param applicationId application id
     * @return ShareTeamApplication
     */
    ShareTeamApplication getShareTeamApplicationByApplicationId(BigInteger applicationId);

    /**
     * 通过请求id获取共享讨论课请求
     *
     * @param applicationId application id
     * @return ShareSeminarApplication
     */
    ShareSeminarApplication getShareSeminarApplicationByApplicationId(BigInteger applicationId);

    /**
     * 删除共享分组请求
     *
     * @param shareTeamApplicationId share team application id
     */
    void deleteShareTeamApplication(BigInteger shareTeamApplicationId);

    /**
     * 删除共享讨论课请求
     *
     * @param shareSeminarApplicationId share seminar application id
     */
    void deleteShareSeminarApplication(BigInteger shareSeminarApplicationId);
}
