package com.test.seminar.dao.impl;

import com.test.seminar.dao.TeacherDao;
import com.test.seminar.entity.Teacher;
import com.test.seminar.mapper.TeacherMapper;
import org.apache.logging.log4j.message.StructuredDataId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherByTeacherId(BigInteger teacherId) {
        return teacherMapper.getTeacherByTeacherId(teacherId);
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
    }

    @Override
    public void updateTeacherByTeacherId(Teacher teacher) {
        teacherMapper.updateTeacherByTeacherId(teacher);
    }

    @Override
    public void deleteTeacherByTeacherId(BigInteger teacherId) {
        teacherMapper.deleteTeacherByTeacherId(teacherId);
    }
}
