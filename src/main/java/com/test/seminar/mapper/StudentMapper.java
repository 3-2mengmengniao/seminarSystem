package com.test.seminar.mapper;

import com.test.seminar.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 *
 * @author zhenweiwang
 * @date 2018/11/29
 *
 */
@Mapper
@Component
public interface StudentMapper {
    /**
     * 通过ID获取学生信息
     * @param studentId
     * @return
     */
    Student getStudentByStudentId(BigInteger studentId);

    /**
     * 创建新的学生账户
     * @param student
     * @return 新建学生的ID
     */
    void insertStudent(Student student);

    /**
     * 更改学生信息
     * @param student
     * @return
     */
    void updateStudentByStudentId(Student student);

    /**
     *
     * @param studentId
     * @return
     */
    void deleteStudentByStudentId(BigInteger studentId);
}
