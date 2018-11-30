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
     *
     * @param courseId
     * @return
     * @throws CourseNotFoundException
     */
    Course getCourseByCourseId(BigInteger courseId)throws CourseNotFoundException;

    /**
     *
     * @param teacherId
     * @return
     */
    List<Course> getCourseByTeacherId(BigInteger teacherId);

    /**
     *
     * @param studentId
     * @return
     */
    List<Course> getCourseByStudentId(BigInteger studentId);

    /**
     *
     * @param Course
     * @throws RepetitiveRecordException
     */
    void insertCourse(Course Course)throws RepetitiveRecordException;

    /**
     *
     * @param course
     * @throws CourseNotFoundException
     */
    void updateCourseByCourseId(Course course)throws CourseNotFoundException;

    /**
     *
     * @param courseId
     * @throws CourseNotFoundException
     */
    void deleteCourseByCourseId(BigInteger courseId)throws CourseNotFoundException;
}
