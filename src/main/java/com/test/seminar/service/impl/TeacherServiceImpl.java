package com.test.seminar.service.impl;

import com.test.seminar.dao.TeacherDao;
import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;
import com.test.seminar.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Teacher getTeacherByTeacherId(BigInteger teacherId) throws UserNotFoundException {
        return teacherDao.getTeacherByTeacherId(teacherId);
    }

    @Override
    public void insertTeacher(Teacher teacher) throws RepetitiveRecordException {
        teacherDao.insertTeacher(teacher);
    }

    @Override
    public void updateTeacherByTeacherId(Teacher teacher) throws UserNotFoundException {
        teacherDao.updateTeacherByTeacherId(teacher);
    }

    @Override
    public void deleteTeacherByTeacherId(BigInteger teacherId) throws UserNotFoundException {
        teacherDao.deleteTeacherByTeacherId(teacherId);
    }

    @Override
    public Teacher getTeacherByAccount(String account)throws UserNotFoundException {
        Teacher teacher= teacherDao.getTeacherByAccount(account);
        if(teacher==null) {
            throw new UserNotFoundException();
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }


}
