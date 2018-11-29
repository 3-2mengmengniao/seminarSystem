package com.test.seminar.dao;

import com.test.seminar.entity.Teacher;

import java.math.BigInteger;

/**
 * @author cxh
 * @date 2018/11/29
 */
public interface TeacherDao {

    /**
     * 通过ID获取老师信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherByTeacherId(BigInteger teacherId);

    /**
     * 创建新的老师账户
     * @param teacher
     * @return 新建老师的ID
     */
    void insertTeacher(Teacher teacher);

    /**
     * 根据老师ID更改老师信息
     * @param teacherId
     * @param teacher
     * @return
     */
    void updateTeacherByTeacherId(BigInteger teacherId, Teacher teacher);

    /**
     *
     * @param teacherId
     * @return
     */
    void deleteTeacherByTeacherId(BigInteger teacherId);
}
