package com.test.seminar.service;

import com.github.pagehelper.PageInfo;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;

import java.math.BigInteger;
import java.security.PublicKey;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface TeacherService {

    /**
     *
     * @param teacherId
     * @return
     * @throws UserNotFoundException
     */
    Teacher getTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException;

    /**
     *
     * @param teacher
     * @throws RepetitiveRecordException
     */
    void insertTeacher(Teacher teacher)throws RepetitiveRecordException;

    /**
     *
     * @param teacher
     * @throws UserNotFoundException
     */
    void updateTeacherByTeacherId( Teacher teacher)throws UserNotFoundException;

    /**
     *
     * @param teacherId
     * @throws UserNotFoundException
     */
    void deleteTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException;

    Teacher getTeacherByAccount(String account);

    List<Teacher> getAllTeacher();

    PageInfo<Teacher> selectTeacherList(Integer pageNum, Integer pageSize);
}
