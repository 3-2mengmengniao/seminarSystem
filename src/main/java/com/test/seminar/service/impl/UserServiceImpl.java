package com.test.seminar.service.impl;

import com.test.seminar.dao.LoginDao;
import com.test.seminar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.seminar.dao.TeacherDao;
import com.test.seminar.entity.Teacher;
import com.test.seminar.dao.StudentDao;
import com.test.seminar.entity.Student;

import java.util.ArrayList;
import java.util.List;
/**
 * @author xmr
 * @date 2018/11/28
 */

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private  TeacherDao teacherDao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名从数据库查询对应记录
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Student student = studentDao.getStudentByAccount(s);
        if (student == null) {
            Teacher teacher=teacherDao.getTeacherByAccount(s);
            if(teacher==null){
                throw new UsernameNotFoundException("username is not exists");
            }
            else{
                List<GrantedAuthority> list = new ArrayList<>();
                list.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
                String password=passwordEncoder.encode(teacher.getPassword());
                org.springframework.security.core.userdetails.User authTeacher = new org.springframework.security.core.userdetails.User(teacher.getAccount(),password,list);
                return authTeacher;
            }
        }
        else{
            List<GrantedAuthority> list = new ArrayList<>();
            list.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
            String password=passwordEncoder.encode(student.getPassword());
            org.springframework.security.core.userdetails.User authStudent = new org.springframework.security.core.userdetails.User(student.getAccount(),password,list);
            return authStudent;
        }
    }
}
