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
     * @param courseId
     * @return
     */
    BigInteger getTeamMainCourseIdBySubCourseId(@Param("courseId")BigInteger courseId);
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

    Course getMainCourseByShareTeamApplicationId(@Param("shareTeamApplicationId")BigInteger shareTeamApplicationId);

    Course getSubCourseByShareTeamApplicationId(@Param("shareTeamApplicationId")BigInteger shareTeamApplicationId);

    /**
     *  插入共享分组的请求
     * @param mainCourseId,subCourseId,subCourseTeacherId
     */
    void insertShareTeamApplication(@Param("mainCourseId")BigInteger mainCourseId,@Param("subCourseId")BigInteger subCourseId,@Param("subCourseTeacherId")BigInteger subCourseTeacherId);

    /**
     *  通过id删除共享分组的请求
     * @param shareTeamApplicationId
     */
    void deleteShareTeamApplication(@Param("shareTeamApplicationId")BigInteger shareTeamApplicationId);

    /**
     *  通过从课程教师id查看共享分组请求
     * @param subCourseTeacherId
     */
    List<ShareTeamApplication> getShareTeamApplicationBySubCourseTeacherId(@Param("subCourseTeacherId")BigInteger subCourseTeacherId);

    /**
     *  通过从课程教师id查看共享分组请求
     * @param subCourseTeacherId
     */
    List<ShareSeminarApplication> getShareSeminarApplicationBySubCourseTeacherId(@Param("subCourseTeacherId")BigInteger subCourseTeacherId);

    Course getMainCourseByShareSeminarApplicationId(@Param("shareTeamApplicationId")BigInteger shareSeminarApplicationId);

    Course getSubCourseByShareSeminarApplicationId(@Param("shareTeamApplicationId")BigInteger shareSeminarApplicationId);

    /**
     *  插入共享讨论课的请求
     * @param mainCourseId,subCourseId,subCourseTeacherId
     */
    void insertShareSeminarApplication(@Param("mainCourseId")BigInteger mainCourseId,@Param("subCourseId")BigInteger subCourseId,@Param("subCourseTeacherId")BigInteger subCourseTeacherId);

    /**
     *  通过id删除共享讨论课的请求
     * @param shareSeminarApplicationId
     */
    void deleteShareSeminarApplication(@Param("shareTeamApplicationId")BigInteger shareSeminarApplicationId);

    /**
     *  更新课程的共享分组的主课程id
     * @param subCourseId,mainCourseId
     */
    void updateCourseTeamMainCourseId(@Param("subCourseId")BigInteger subCourseId,@Param("mainCourseId")BigInteger mainCourseId);

    /**
     *  更新课程的共享讨论课的主课程id
     * @param subCourseId,mainCourseId
     */
    void updateCourseSeminarMainCourseId(@Param("subCourseId")BigInteger subCourseId,@Param("mainCourseId")BigInteger mainCourseId);

    /**
     * 获取系统中所有课程
     * @return
     */
    List<Course> getAllCourse();
}
