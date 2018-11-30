package com.test.seminar.dao;


import com.test.seminar.entity.Course;

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
    Course getCourseByCourseId(BigInteger courseId);

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
     * 创建新的课程账户
     * @param Course
     * @return 新建课程的ID
     */
    void insertCourse(Course Course);

    /**
     * 更改课程信息
     * @param course
     * @return
     */
    void updateCourseByCourseId(Course course);

    /**
     *
     * @param courseId
     * @return
     */
    void deleteCourseByCourseId(BigInteger courseId);
}
