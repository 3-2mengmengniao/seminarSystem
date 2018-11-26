package com.test.seminar.service.impl;

import com.test.seminar.dao.LoginDao;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhenweiwang
 * @date 2018/11/26
 */
@Service
public class LoginServiceImlp implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public Student studentLogin(String account, String password) {
        return loginDao.studentLogin(account, password);
    }

    @Override
    public Teacher teacherLogin(String account, String password) {
        return loginDao.teacherLogin(account, password);
    }

}
