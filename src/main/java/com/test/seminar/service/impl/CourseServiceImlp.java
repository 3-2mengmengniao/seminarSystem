package com.test.seminar.service.impl;

import com.test.seminar.mapper.CourseMapper;
import com.test.seminar.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImlp implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
}
