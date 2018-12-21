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
    void updateStudentByStudentId(Student student)throws UserNotFoundException;

    /**
     * @param studentId
     * @return
     */
    void deleteStudentByStudentId(BigInteger studentId)throws UserNotFoundException;
}