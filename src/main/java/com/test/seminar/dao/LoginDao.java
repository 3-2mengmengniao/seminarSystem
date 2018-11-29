package com.test.seminar.dao;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;

/**
 * @author zhenweiwang
 * @date 2018/11/26
 */
public interface LoginDao {

    /**
     *
     * @param account
     * @param password
     * @return
     */
    Student studentLogin(String account, String password);

    /**
     *
     * @param account
     * @param password
     * @return
     */
    Teacher teacherLogin(String account, String password);
}
