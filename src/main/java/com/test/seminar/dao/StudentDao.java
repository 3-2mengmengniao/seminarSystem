package com.test.seminar.dao;

import com.test.seminar.entity.Student;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface StudentDao {

    /**
     * 通过ID获取学生信息
     * @param studentId
     * @return
     */
    Student getStudentByStudentId(BigInteger studentId);

    /**
     * 创建新的学生账户
     * @param student
     * @return 新建学生的ID
     */
    void insertStudent(Student student);

    /**
     * 创建新的学生账户
     * @param studentList
     * @return 新建学生的ID
     */
    void insertStudentByStudentList(List<Student> studentList);

    /**
     * 更改学生信息
     * @param student
     * @return
     */
    void updateStudentByStudentId(Student student);

    /**
     *
     * @param studentId
     * @return
     */
    void deleteStudentByStudentId(BigInteger studentId);
}
