package com.test.seminar.dao.impl;

import com.test.seminar.dao.TeacherDao;
import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;
import com.test.seminar.mapper.TeacherMapper;
import org.apache.logging.log4j.message.StructuredDataId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException {
        Teacher teacher=teacherMapper.getTeacherByTeacherId(teacherId);
        if(teacher==null) {
            throw new UserNotFoundException();
        }
        return teacher;
    }

    @Override
    public Teacher getTeacherByAccount(String account) {
        return teacherMapper.getTeacherByAccount(account);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherMapper.getAllTeacher();
    }

    @Override
    public void insertTeacher(Teacher teacher)throws RepetitiveRecordException {
        teacherMapper.insertTeacher(teacher);
    }

    @Override
    public void updateTeacherByTeacherId(Teacher teacher)throws UserNotFoundException {
        if(teacherMapper.getTeacherByTeacherId(teacher.getId())==null) {
            throw new UserNotFoundException();
        }
        teacherMapper.updateTeacherByTeacherId(teacher);
    }

    @Override
    public void deleteTeacherByTeacherId(BigInteger teacherId)throws UserNotFoundException {
        if(teacherMapper.getTeacherByTeacherId(teacherId)==null) {
            throw new UserNotFoundException();
        }
        teacherMapper.deleteTeacherByTeacherId(teacherId);
    }
}