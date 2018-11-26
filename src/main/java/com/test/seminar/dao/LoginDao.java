package com.test.seminar.dao;

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
public class LoginDao {
    @Autowired
    private LoginMapper loginMapper;

    public Student studentLogin(String account, String password) {
        return loginMapper.studentLogin(account, password);
    }

    public Teacher teacherLogin(String account, String password) {
        return loginMapper.teacherLogin(account, password);
    }
}
