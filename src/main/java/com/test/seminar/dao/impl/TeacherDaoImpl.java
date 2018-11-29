package com.test.seminar.dao.impl;

import com.test.seminar.dao.TeacherDao;
import com.test.seminar.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    private TeacherMapper TeacherMapper;
}
