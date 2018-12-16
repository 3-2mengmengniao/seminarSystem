package com.test.seminar.service.impl;

import com.test.seminar.dao.SeminarDao;
import com.test.seminar.dao.StudentDao;
import com.test.seminar.entity.Student;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;
import com.test.seminar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student getStudentByStudentId(BigInteger studentId) throws UserNotFoundException {
        Student student=studentDao.getStudentByStudentId(studentId);
        if(student==null) {
            throw new UserNotFoundException();
        }
        return student;
    }

    @Override
    public void insertStudent(Student student) throws RepetitiveRecordException {
        studentDao.insertStudent(student);
    }

    @Override
    public void updateStudentByStudentId(Student student) throws UserNotFoundException {
        if(studentDao.getStudentByStudentId(student.getId())==null) {
            throw new UserNotFoundException();
        }
        studentDao.updateStudentByStudentId(student);
    }

    @Override
    public void deleteStudentByStudentId(BigInteger studentId) throws UserNotFoundException {
        if(studentDao.getStudentByStudentId(studentId)==null) {
            throw new UserNotFoundException();
        }
        studentDao.deleteStudentByStudentId(studentId);
    }

    @Override
    public List<Student> getStudentByTeamId(BigInteger teamId) {
        return studentDao.getStudentByTeamId(teamId);
    }

    @Override
    public Student getStudentByAccount(String account) throws UserNotFoundException {
        Student student=studentDao.getStudentByAccount(account);
        if(student==null) {
            throw new UserNotFoundException();
        }
        return student;
    }
}
