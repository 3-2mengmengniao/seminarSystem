package com.test.seminar.service.impl;

import com.test.seminar.dao.TeacherDao;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.Teacher;
import com.test.seminar.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Course> getCourses(Teacher teacher){
        return null;
    }
}
