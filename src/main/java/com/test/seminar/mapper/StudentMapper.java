package com.test.seminar.mapper;

import com.test.seminar.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Mapper
@Component
public interface StudentMapper {
    /**
     * 通过ID获取学生信息
     *
     * @param studentId
     * @return
     */
    Student getStudentByStudentId(@Param("studentId") BigInteger studentId);

    /**
     * 通过account获取学生信息
     *
     * @param account
     * @return
     */
    Student getStudentByAccount(String account);

    /**
     * 创建新的学生账户
     *
     * @param student
     * @return
     */
    void insertStudent(@Param("student") Student student);

    /**
     * 更改学生信息
     *
     * @param student
     * @return
     */
    void updateStudentByStudentId(@Param("student") Student student);

    /**
     * 删除学生
     *
     * @param studentId
     * @return
     */
    void deleteStudentByStudentId(@Param("studentId") BigInteger studentId);

    /**
     * @param teamId
     * @return
     */
    List<Student> getStudentByTeamId(BigInteger teamId);
}
