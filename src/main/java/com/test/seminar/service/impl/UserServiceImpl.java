package com.test.seminar.service.impl;

import com.test.seminar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.seminar.dao.TeacherDao;
import com.test.seminar.entity.Teacher;
import com.test.seminar.dao.StudentDao;
import com.test.seminar.entity.Student;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private  TeacherDao teacherDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名从数据库查询对应记录
        Student student = studentDao.getStudentByAccount(s);
        if (student == null) {
            Teacher teacher=teacherDao.getTeacherByAccount(s);
            if(teacher==null){
                throw new UsernameNotFoundException("username is not exists");
            }
            else
                 return teacher;
        }
        else
            return student;
    }
}
