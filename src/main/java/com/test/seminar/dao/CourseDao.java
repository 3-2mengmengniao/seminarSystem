package com.test.seminar.dao;


import com.test.seminar.entity.Course;
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
     * @param courseId
     * @return
     */
    Course getCourseByCourseId(BigInteger courseId)  throws CourseNotFoundException;

    /**
     * 根据课程ID获得共享讨论课从课程列表
     * @param seminarMainCourseId
     * @return
     */
    List<Course> getCourseBySeminarMainCourseId(BigInteger seminarMainCourseId);

    /**
     * 根据课程ID获得共享分组从课程
     * @param teamMainCourseId
     * @return
     */
    List<Course> getCourseByTeamMainCourseId(BigInteger teamMainCourseId);

    /**
     * 通过老师ID获取课程列表
     * @param teacherId
     * @return
     */
    List<Course> getCourseByTeacherId(BigInteger teacherId);

    /**
     * 通过学生ID获取课程列表
     * @param studentId
     * @return
     */
    List<Course> getCourseByStudentId(BigInteger studentId);

    /**
     * 创建新的课程
     * @param course
     * @return
     */
    void insertCourse(Course course,BigInteger teacherId)throws RepetitiveRecordException;

    /**
     * 更改课程信息
     * @param course
     * @return
     */
    void updateCourseByCourseId(Course course)throws CourseNotFoundException;

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    void deleteCourseByCourseId(BigInteger courseId)throws CourseNotFoundException;

    /**
     *  插入共享分组的请求
     * @param mainCourseId,subCourseId,subCourseTeacherId
     */
    void insertShareTeamApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId);

    /**
     *  通过id删除共享分组的请求
     * @param shareTeamApplicationId
     */
    void deleteShareTeamApplication(BigInteger shareTeamApplicationId);

    /**
     *  通过从课程教师id查看共享分组请求
     * @param subCourseTeacherId
     */
    List<ShareTeamApplication> getShareTeamApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId) throws ShareTeamApplicationNotFoundException;

    /**
     *  从课程教师同意共享分组请求后，建立共享关联
     * @param shareTeamApplication
     */
    void createShareTeamAssociation(ShareTeamApplication shareTeamApplication);

    /**
     * 获取系统下所有课程
     * @return
     */
    List<Course> getAllCourse();

    Course getCourseByCourseNameAndTeacherId(String courseName,BigInteger teacherId);
}