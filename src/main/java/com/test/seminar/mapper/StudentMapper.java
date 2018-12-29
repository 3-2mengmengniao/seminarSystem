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
     * @param teamId
     * @return
     */
    List<Student> getStudentByTeamId(@Param("teamId")BigInteger teamId);

    /**
     * @param courseClassId
     * @return
     */
    List<Student> getStudentByCourseClassId(@Param("courseClassId")BigInteger courseClassId);

    /**
     * @return
     */
    List<Student> getAllStudent();

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
    void updateStudentByStudent(@Param("student") Student student);

    /**
     * 删除学生
     *
     * @param studentId
     * @return
     */
    void deleteStudentByStudentId(@Param("studentId") BigInteger studentId);

    /**
     * 获取课程中的未组队学生
     * @param courseId
     * @return
     */
    List<Student> getStudentNotInTeamByCourseId(@Param("courseId")BigInteger courseId);

    List<Student> getStudentNotInTeamByCourseIdForSubCourse(@Param("courseId")BigInteger courseId,@Param("mainCourseId")BigInteger mainCourseId);
}
