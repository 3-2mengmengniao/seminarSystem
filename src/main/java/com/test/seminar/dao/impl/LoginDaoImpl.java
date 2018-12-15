package com.test.seminar.dao.impl;


import com.test.seminar.dao.LoginDao;
import com.test.seminar.entity.Admin;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhenweiwang
 * @date 2018/11/26
 */
@Component
public class LoginDaoImpl implements LoginDao {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Student studentLogin(String account, String password) {
        return loginMapper.studentLogin(account, password);
    }

    @Override
    public Teacher teacherLogin(String account, String password) {
        return loginMapper.teacherLogin(account, password);
    }

    @Override
    public Admin adminLogin(String account, String password) {
        return loginMapper.adminLogin(account,password);
    }
}