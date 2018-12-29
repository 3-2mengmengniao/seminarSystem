package com.test.seminar.service;

import com.test.seminar.entity.Admin;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.UserNotFoundException;

/**
 * @author zhenweiwang
 * @date 2018/11/26
 */
public interface LoginService {

    /**
     * 学生登录
     * @param account
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    Student studentLogin(String account, String password)throws UserNotFoundException;

    /**
     * 教师登录
     * @param account
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    Teacher teacherLogin(String account, String password)throws UserNotFoundException;
}
