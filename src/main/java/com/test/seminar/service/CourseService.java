package com.test.seminar.service;

import com.test.seminar.entity.Course;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface CourseService {

    /**
     * 通过ID获取课程信息
     * @param courseId
     * @return
     * @throws CourseNotFoundException
     */
    Course getCourseByCourseId(BigInteger courseId)throws CourseNotFoundException;

    /**
     * 创建新的课程
     * @param Course
     * @throws RepetitiveRecordException
     */
    void insertCourse(Course Course,BigInteger teacherId)throws RepetitiveRecordException;

    /**
     * 更改课程信息
     * @param course
     * @throws CourseNotFoundException
     */
    void updateCourseByCourseId(Course course)throws CourseNotFoundException;

    /**
     * 删除课程
     * @param courseId
     * @throws CourseNotFoundException
     */
    void deleteCourseByCourseId(BigInteger courseId)throws CourseNotFoundException;
}
