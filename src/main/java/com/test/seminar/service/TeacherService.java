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
     *根据Id获得老师
     * @param teacherId
     * @return
     * @throws UserNotFoundException
     */
    Teacher getTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException;

    /**
     *创建老师
     * @param teacher
     * @throws RepetitiveRecordException
     */
    void insertTeacher(Teacher teacher)throws RepetitiveRecordException;

    /**
     *更新老师信息
     * @param teacher
     * @throws UserNotFoundException
     */
    void updateTeacherByTeacherId( Teacher teacher)throws UserNotFoundException;

    /**
     *删除老师
     * @param teacherId
     * @throws UserNotFoundException
     */
    void deleteTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException;

    /**
     * 根据账号获得老师
     * @param account
     * @return
     */
    Teacher getTeacherByAccount(String account);

    /**
     * 获得所有老师
     * @return
     */
    List<Teacher> getAllTeacher();

    /**
     * 分页获得老师
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Teacher> selectTeacherList(Integer pageNum, Integer pageSize);
}
