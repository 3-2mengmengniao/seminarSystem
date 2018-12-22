package com.test.seminar.service;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.Student;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;
import org.apache.catalina.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface StudentService {

    /**
     *
     * @param studentId
     * @return
     * @throws UserNotFoundException
     */
    Student getStudentByStudentId(BigInteger studentId) throws UserNotFoundException;

    /**
     *
     * @param student
     * @throws RepetitiveRecordException
     */
    void insertStudent(Student student)throws RepetitiveRecordException;

    /**
     *
     * @param student
     * @throws UserNotFoundException
     */
    void updateStudentByStudentId(Student student)throws UserNotFoundException;

    /**
     *
     * @param studentId
     * @throws UserNotFoundException
     */
    void deleteStudentByStudentId(BigInteger studentId)throws UserNotFoundException;

    List<Student> getStudentByTeamId(BigInteger teamId);

    Student getStudentByAccount(String acoount)throws UserNotFoundException;

    List<Student> getAllStudent();

    List<Student> getStudentNotTeamInCourse(BigInteger courseId);
}
