package com.test.seminar.service.impl;

import com.test.seminar.dao.StudentDao;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.Student;
import com.test.seminar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Course> getCourses(Student student){
        return null;
    }
}
