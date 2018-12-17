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
     * @param teacherId
     * @return
     */
    Teacher getTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException;

    /**
     * 通过account获取教师信息
     *
     * @param account
     * @return
     */
    Teacher getTeacherByAccount(String account);

    /**
     * 创建新的老师账户
     *
     * @param teacher
     * @return
     */
    void insertTeacher(Teacher teacher)throws RepetitiveRecordException;

    /**
     * 更改老师信息
     *
     * @param teacher
     * @return
     */
    void updateTeacherByTeacherId(Teacher teacher)throws UserNotFoundException;

    /**
     * @param teacherId
     * @return
     */
    void deleteTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException;

    /**
     * @return
     */
    List<Teacher> getAllTeacher();
}
