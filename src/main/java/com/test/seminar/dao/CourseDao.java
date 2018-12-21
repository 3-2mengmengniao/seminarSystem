package com.test.seminar.dao;


import com.test.seminar.entity.Course;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;

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
}