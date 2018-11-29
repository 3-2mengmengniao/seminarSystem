package com.test.seminar.dao.impl;

import com.test.seminar.dao.StudentDao;
import com.test.seminar.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDaoImpl implements  StudentDao{
    @Autowired
    private StudentMapper studentMapper;
}
