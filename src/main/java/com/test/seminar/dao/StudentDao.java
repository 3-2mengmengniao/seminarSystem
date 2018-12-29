package com.test.seminar.dao;

import com.test.seminar.entity.Student;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface StudentDao {

    /**
     * 通过ID获取学生信息
     *
     * @param studentId
     * @return
     */
    Student getStudentByStudentId(BigInteger studentId)throws UserNotFoundException;

    /**
     * 通过account获取学生信息
     *
     * @param account
     * @return
     */
    Student getStudentByAccount(String account);
    /**
     * @param teamId
     * @return
     */
    List<Student> getStudentByTeamId(BigInteger teamId);

    /**
     * @param courseClassId
     * @return
     */
    List<Student> getStudentByCourseClassId(BigInteger courseClassId);

    /**
     * @return
     */
    List<Student> getAllStudent();

    /**
     * 创建新的学生账户
     *
     * @param student
     * @return 新建学生的ID
     */
    void insertStudent(Student student)throws RepetitiveRecordException;

    /**
     * 更改学生信息
     *
     * @param student
     * @return
     */
    void updateStudentByStudent(Student student)throws UserNotFoundException;

    /**
     * @param studentId
     * @return
     */
    void deleteStudentByStudentId(BigInteger studentId)throws UserNotFoundException;

    /**
     * 获取课程中未组队学生
     * @param courseId
     * @return
     */
    List<Student> getStudentNotInTeamByCourseId(BigInteger courseId);
}