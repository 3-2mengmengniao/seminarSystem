package com.test.seminar.dao;

import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface TeacherDao {

    /**
     * 通过ID获取老师信息
     *
     * @param teacherId teacher id
     * @return Teacher
     * @throws UserNotFoundException user not found
     */
    Teacher getTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException;

    /**
     * 通过account获取教师信息
     *
     * @param account account
     * @return Teacher
     */
    Teacher getTeacherByAccount(String account);


    /**
     * 获取所有教师
     *
     * @return List<Teacher>
     */
    List<Teacher> getAllTeacher();

    /**
     * 创建新的老师账户
     *
     * @param teacher teacher
     * @throws RepetitiveRecordException repetitive record found
     */
    void insertTeacher(Teacher teacher)throws RepetitiveRecordException;

    /**
     * 更改老师信息
     *
     * @param teacher teacher
     * @throws UserNotFoundException user not found
     */
    void updateTeacherByTeacherId(Teacher teacher)throws UserNotFoundException;

    /**
     * 通过id删除教师
     *
     * @param teacherId teacher id
     * @throws UserNotFoundException user not found
     */
    void deleteTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException;
}