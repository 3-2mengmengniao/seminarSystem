package com.test.seminar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
/**
 * @author xmr
 * @date 2018/11/28
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student getStudentByStudentId(BigInteger studentId) throws UserNotFoundException {
        return studentDao.getStudentByStudentId(studentId);
    }

    @Override
    public void insertStudent(Student student) throws RepetitiveRecordException {
        studentDao.insertStudent(student);
    }

    @Override
    public void updateStudentByStudent(Student student) throws UserNotFoundException {
        studentDao.updateStudentByStudent(student);
    }

    @Override
    public void deleteStudentByStudentId(BigInteger studentId) throws UserNotFoundException {
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

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public PageInfo<Student> selectStudentList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> list = studentDao.getAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
