package com.test.seminar.dao.impl;

import com.test.seminar.dao.StudentDao;
import com.test.seminar.entity.Student;
import com.test.seminar.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class StudentDaoImpl implements StudentDao {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getStudentByStudentId(BigInteger studentId) {
        return studentMapper.getStudentByStudentId(studentId);
    }

    @Override
    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public void insertStudentByStudentList(List<Student> studentList) {
        for(Student student:studentList){
            studentMapper.insertStudent(student);
        }
    }

    @Override
    public void updateStudentByStudentId(Student student) {
        studentMapper.updateStudentByStudentId(student);
    }

    @Override
    public void deleteStudentByStudentId(BigInteger studentId) {
        studentMapper.deleteStudentByStudentId(studentId);
    }

    @Override
    public List<Student> getStudentByTeamId(BigInteger teamId) {
        return studentMapper.getStudentByTeamId(teamId);
    }
}
