package com.test.seminar.service;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;

/**
 * @author zhenweiwang
 * @date 2018/11/26
 */
public interface LoginService {

    Student studentLogin(String account, String password);

    Teacher teacherLogin(String account, String password);
}
