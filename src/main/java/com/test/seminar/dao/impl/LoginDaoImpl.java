package com.test.seminar.dao.impl;


import com.test.seminar.dao.LoginDao;
import com.test.seminar.entity.Admin;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.UserNotFoundException;
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
    public Student studentLogin(String account, String password)throws UserNotFoundException {
        Student student=loginMapper.studentLogin(account, password);
        if(student==null) {
            throw new UserNotFoundException();
        }
        return student;
    }

    @Override
    public Teacher teacherLogin(String account, String password)throws UserNotFoundException {
        Teacher teacher=loginMapper.teacherLogin(account, password);
        if(teacher==null) {
            throw new UserNotFoundException();
        }
        return teacher;
    }

    @Override
    public Admin adminLogin(String account) {
        return loginMapper.adminLogin(account);
    }
}