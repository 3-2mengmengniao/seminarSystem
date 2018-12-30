package com.test.seminar.mapper;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.ShareSeminarApplication;
import com.test.seminar.entity.ShareTeamApplication;
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
     * 通过从课程id获取主课程id
     * @param courseId course id
     * @return BigInteger
     */
    BigInteger getTeamMainCourseIdBySubCourseId(@Param("courseId")BigInteger courseId);
    /**
     * 通过ID获取课程信息
     * @param courseId course id
     * @return course
     */
    Course getCourseByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 通过课程班级id获取课程
     *
     * @param courseClassId course class id
     * @return Course
     */
    Course getCourseByCourseClassId(@Param("courseClassId")BigInteger courseClassId);

    /**
     * 通过老师ID获取课程列表
     *
     * @param teacherId teacher id
     * @return List<Course>
     */
    List<Course> getCourseByTeacherId(@Param("teacherId")BigInteger teacherId);

    /**
     * 通过学生ID获取课程列表
     *
     * @param studentId student id
     * @return List<Course>
     */
    List<Course> getCourseByStudentId(@Param("studentId")BigInteger studentId);

    /**
     * 通过讨论课主课程id获取课程
     *
     * @param seminarMainCourseId seminar main course id
     * @return List<Course>
     */
    List<Course> getCourseBySeminarMainCourseId(@Param("seminarMainCourseId")BigInteger seminarMainCourseId);

    /**
     * 通过分组主课程id获取课程
     * @param teamMainCourseId team main course id
     * @return List<Course>
     */
    List<Course> getCourseByTeamMainCourseId(@Param("teamMainCourseId")BigInteger teamMainCourseId);
    /**
     * 创建新的课程账户
     *
     * @param course course
     * @param teacherId teacher id
     */
    void insertCourse(@Param("course") Course course,@Param("teacherId")BigInteger teacherId);

    /**
     * 更改课程信息
     * @param course course
     */
    void updateCourse(@Param("course")Course course);

    /**
     * 通过课程id删除课程
     *
     * @param courseId course id
     */
    void deleteCourseByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 通过共享
     *
     * @param shareTeamApplicationId share team application
     * @return Course
     */
    Course getMainCourseByShareTeamApplicationId(@Param("shareTeamApplicationId")BigInteger shareTeamApplicationId);

    /**
     * 通过共享分组请求获取从课程
     *
     * @param shareTeamApplicationId share team application id
     * @return Course
     */
    Course getSubCourseByShareTeamApplicationId(@Param("shareTeamApplicationId")BigInteger shareTeamApplicationId);

    /**
     * 通过请求id获取共享分组请求
     *
     * @param applicationId application id
     * @return ShareTeamApplication
     */
    ShareTeamApplication getShareTeamApplicationByApplicationId(@Param("applicationId")BigInteger applicationId);

    /**
     *  插入共享分组的请求
     *
     * @param mainCourseId main course id
     * @param subCourseId sub course id
     * @param subCourseTeacherId sub course teacher id
     */
    void insertShareTeamApplication(@Param("mainCourseId")BigInteger mainCourseId,@Param("subCourseId")BigInteger subCourseId,@Param("subCourseTeacherId")BigInteger subCourseTeacherId);

    /**
     *  通过id删除共享分组的请求
     * @param shareTeamApplicationId share team application id
     */
    void deleteShareTeamApplication(@Param("shareTeamApplicationId")BigInteger shareTeamApplicationId);

    /**
     *  通过从课程教师id查看共享分组请求
     * @param subCourseTeacherId sub course teacher id
     * @return  List<ShareTeamApplication>
     */
    List<ShareTeamApplication> getShareTeamApplicationBySubCourseTeacherId(@Param("subCourseTeacherId")BigInteger subCourseTeacherId);

    /**
     *  通过从课程教师id查看共享分组请求
     * @param subCourseTeacherId sub course teacher id
     * @return  List<ShareSeminarApplication>
     */
    List<ShareSeminarApplication> getShareSeminarApplicationBySubCourseTeacherId(@Param("subCourseTeacherId")BigInteger subCourseTeacherId);

    /**
     * 通过共享讨论课请求获取主课程
     *
     * @param shareSeminarApplicationId share seminar application id
     * @return Course
     */
    Course getMainCourseByShareSeminarApplicationId(@Param("shareTeamApplicationId")BigInteger shareSeminarApplicationId);

    /**
     * 通过共享讨论课请求获取从课程
     *
     * @param shareSeminarApplicationId share seminar application id
     * @return course
     */
    Course getSubCourseByShareSeminarApplicationId(@Param("shareTeamApplicationId")BigInteger shareSeminarApplicationId);

    /**
     * 通过id获取共享讨论课申请
     *
     * @param applicationId application id
     * @return ShareSeminarApplication
     */
    ShareSeminarApplication getShareSeminarApplicationByApplicationId(@Param("applicationId")BigInteger applicationId);
    /**
     *  插入共享讨论课的请求
     * @param mainCourseId main course id
     * @param subCourseId sub course id
     * @param subCourseTeacherId sub course teacher id
     */
    void insertShareSeminarApplication(@Param("mainCourseId")BigInteger mainCourseId,@Param("subCourseId")BigInteger subCourseId,@Param("subCourseTeacherId")BigInteger subCourseTeacherId);

    /**
     *  通过id删除共享讨论课的请求
     * @param shareSeminarApplicationId share seminar application id
     */
    void deleteShareSeminarApplication(@Param("shareTeamApplicationId")BigInteger shareSeminarApplicationId);

    /**
     *  更新课程的共享分组的主课程id
     * @param subCourseId sub course id
     * @param mainCourseId main course id
     */
    void updateCourseTeamMainCourseId(@Param("subCourseId")BigInteger subCourseId,@Param("mainCourseId")BigInteger mainCourseId);

    /**
     *  更新课程的共享讨论课的主课程id
     * @param subCourseId sub course id
     * @param mainCourseId main course id
     */
    void updateCourseSeminarMainCourseId(@Param("subCourseId")BigInteger subCourseId,@Param("mainCourseId")BigInteger mainCourseId);

    /**
     * 获取系统中所有课程
     *
     * @return List<Course>
     */
    List<Course> getAllCourse();

    /**
     * 获取未向该课程发起共享的课程
     *
     * @param courseId course id
     * @return List<Course>
     */
    List<Course> getAvailableCourseForShare(@Param("courseId")BigInteger courseId);

    /**
     * 获取轮次对应的课程
     * @param roundId round id
     * @return Course
     */
    Course getCourseByRoundId(@Param("roundId")BigInteger roundId);

    /**
     * 通过课程名和老师id获取课程
     *
     * @param courseName course name
     * @param teacherId teacher id
     * @return Course
     */
    Course getCourseByCourseNameAndTeacherId(@Param("courseName")String courseName, @Param("teacherId")BigInteger teacherId);
}
