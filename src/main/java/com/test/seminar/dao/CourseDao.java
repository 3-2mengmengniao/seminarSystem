package com.test.seminar.dao;


import com.test.seminar.entity.Course;
import com.test.seminar.entity.ShareSeminarApplication;
import com.test.seminar.entity.ShareTeamApplication;
import com.test.seminar.entity.Team;
import com.test.seminar.entity.strategy.TeamStrategy;
import com.test.seminar.entity.strategy.impl.*;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.ShareTeamApplicationNotFoundException;
import com.test.seminar.exception.StrategyNotFoundException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/24
 */
public interface CourseDao {
    /**
     * 通过ID获取课程信息
     * @param courseId course id
     * @return Course
     * @throws CourseNotFoundException
     */
    Course getCourseByCourseId(BigInteger courseId)  throws CourseNotFoundException;

    /**
     * 根据课程ID获得共享讨论课从课程列表
     *
     * @param seminarMainCourseId seminar main course id
     * @return List<Course>
     */
    List<Course> getCourseBySeminarMainCourseId(BigInteger seminarMainCourseId);

    /**
     * 根据课程ID获得共享分组从课程
     * @param teamMainCourseId team main course id
     * @return List<Course>
     */
    List<Course> getCourseByTeamMainCourseId(BigInteger teamMainCourseId);

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
     * 创建新的课程
     * @param course course
     * @param teacherId teacher id
     * @throws RepetitiveRecordException repetitive record found
     */
    void insertCourse(Course course,BigInteger teacherId)throws RepetitiveRecordException;

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
     * 插入共享分组的请求
     *
     * @param mainCourseId main course id
     * @param subCourseId sub course id
     * @param subCourseTeacherId sub course teacher id
     */
    void insertShareTeamApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId);

    /**
     *  通过id删除共享分组的请求
     * @param shareTeamApplicationId share team application id
     */
    void deleteShareTeamApplication(BigInteger shareTeamApplicationId);

    /**
     * 删除共享讨论课请求
     *
     * @param shareSeminarApplicationId share seminar application id
     */
    void deleteShareSeminarApplication(BigInteger shareSeminarApplicationId);

    /**
     *  通过从课程教师id查看共享分组请求
     * @param subCourseTeacherId sub course teacher id
     * @return List<ShareTeamApplication>
     */
    List<ShareTeamApplication> getShareTeamApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId);

    /**
     *  通过从课程教师id查看共享分组请求
     * @param subCourseTeacherId sub course teacher id
     * @return List<ShareSeminarApplication>
     */
    List<ShareSeminarApplication> getShareSeminarApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId);

    /**
     * 通过共享讨论课请求获取主课程
     *
     * @param shareSeminarApplicationId share seminar application id
     * @return Course
     */
    Course getMainCourseByShareSeminarApplicationId(BigInteger shareSeminarApplicationId);

    /**
     * 通过共享讨论课请求获取从课程
     *
     * @param shareSeminarApplicationId share Seminar Application Id
     * @return Course
     */
    Course getSubCourseByShareSeminarApplicationId(BigInteger shareSeminarApplicationId);

    /**
     * 通过请求id获取共享组队共享请求
     *
     * @param applicationId application
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
     * 插入共享讨论课的请求
     *
     * @param mainCourseId main course id
     * @param subCourseId sub course id
     * @param subCourseTeacherId sub course teacher id
     */
    void insertShareSeminarApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId);

    /**
     *  从课程教师同意共享分组请求后，建立共享关联
     * @param shareTeamApplication share team application
     */
    void createShareTeamAssociation(ShareTeamApplication shareTeamApplication);


    /**
     * 更新课程的共享讨论课的主课程id
     *
     * @param subCourseId sub course id
     * @param mainCourseId main course id
     */
    void updateCourseTeamMainCourseId(BigInteger subCourseId,BigInteger mainCourseId);

    /**
     *  更新课程的共享讨论课的主课程id
     *
     * @param subCourseId sub course id
     * @param mainCourseId main course id
     */
    void updateCourseSeminarMainCourseId(BigInteger subCourseId,BigInteger mainCourseId);


    /**
     * 获取系统下所有课程
     * @return List<Course>
     */
    List<Course> getAllCourse();

    /**
     * 通过课程名和教师id获取课程
     *
     * @param courseName course name
     * @param teacherId teacher id
     * @return Course
     */
    Course getCourseByCourseNameAndTeacherId(String courseName,BigInteger teacherId);

    /**
     * 获取未向该课程发起共享的课程
     *
     * @param courseId course id
     * @return List<Course>
     */
    List<Course> getAvailableCourseForShare(BigInteger courseId);

    /**
     * 获取轮次对应的课程
     * @param roundId round id
     * @return Course
     */
    Course getCourseByRoundId(BigInteger roundId);
}