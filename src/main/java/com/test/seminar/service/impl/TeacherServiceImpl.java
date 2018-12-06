package com.test.seminar.service.impl;

import com.test.seminar.dao.TeacherDao;
import com.test.seminar.entity.Teacher;
import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;
import com.test.seminar.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Teacher getTeacherByTeacherId(BigInteger teacherId) throws UserNotFoundException {
        Teacher teacher=teacherDao.getTeacherByTeacherId(teacherId);
        if(teacher==null)
            throw new UserNotFoundException();
        return teacher;
    }

    @Override
    public void insertTeacher(Teacher teacher) throws RepetitiveRecordException {
        teacherDao.insertTeacher(teacher);
    }

    @Override
    public void updateTeacherByTeacherId(Teacher teacher) throws UserNotFoundException {
        if(teacherDao.getTeacherByTeacherId(teacher.getId())==null)
            throw new UserNotFoundException();
        teacherDao.updateTeacherByTeacherId(teacher);
    }

    @Override
    public void deleteTeacherByTeacherId(BigInteger teacherId) throws UserNotFoundException {
        if(teacherDao.getTeacherByTeacherId(teacherId)==null)
            throw new UserNotFoundException();
        teacherDao.deleteTeacherByTeacherId(teacherId);
    }
}
