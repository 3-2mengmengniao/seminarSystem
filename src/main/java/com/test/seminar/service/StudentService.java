package com.test.seminar.service;

import com.github.pagehelper.PageInfo;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.Student;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.UserNotFoundException;
import org.apache.catalina.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface StudentService {

    /**
     *根据Id查找学生
     * @param studentId
     * @return
     * @throws UserNotFoundException
     */
    Student getStudentByStudentId(BigInteger studentId) throws UserNotFoundException;

    /**
     *更新学生信息
     * @param student
     * @throws UserNotFoundException
     */
    void updateStudentByStudent(Student student)throws UserNotFoundException;

    /**
     *删除学生
     * @param studentId
     * @throws UserNotFoundException
     */
    void deleteStudentByStudentId(BigInteger studentId)throws UserNotFoundException;

    /**
     * 根据账号获得学生
     * @param acoount
     * @return
     * @throws UserNotFoundException
     */
    Student getStudentByAccount(String acoount)throws UserNotFoundException;

    /**
     * 获得所有学生
     * @return
     */
    List<Student> getAllStudent();

    /**
     * 获得分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Student> selectStudentList(Integer pageNum, Integer pageSize);
}
