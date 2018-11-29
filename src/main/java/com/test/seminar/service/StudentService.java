package com.test.seminar.service;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.Student;

import java.security.PublicKey;
import java.util.List;

public interface StudentService {
    List<Course> getCourses(Student student);
}
