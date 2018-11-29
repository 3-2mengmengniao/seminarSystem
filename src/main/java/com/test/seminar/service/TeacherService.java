package com.test.seminar.service;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.Teacher;

import java.security.PublicKey;
import java.util.List;

public interface TeacherService {
    List<Course> getCourses(Teacher teacher);
}
