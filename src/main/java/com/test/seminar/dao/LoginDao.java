package com.test.seminar.dao;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.entity.User;
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

    public User userLogin(String account, String password) {
        Student student = loginMapper.studentLogin(account, password);
        if (student == null) {
            Teacher teacher=loginMapper.teacherLogin(account,password);
            if (teacher==null){
                return null;
            }else{
                teacher.setType("teacher");
                return teacher;
            }
        }else{
            student.setType("student");
            return student;
        }
    }
}
