package com.test.seminar.mapper;


import com.test.seminar.entity.Teacher;
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
public interface TeacherMapper {
    /**
     * 通过ID获取老师信息
     *
     * @param teacherId teacher id
     * @return Teacher
     */
    Teacher getTeacherByTeacherId(@Param("teacherId") BigInteger teacherId);

    /**
     * 通过account获取教师信息
     *
     * @param account account
     * @return Teacher
     */
    Teacher getTeacherByAccount(String account);

    /**
     * 获取所有教师
     *
     * @return List<Teacher>
     */
    List<Teacher> getAllTeacher();

    /**
     * 创建新的老师账户
     *
     * @param teacher teacher
     */
    void insertTeacher(@Param("teacher") Teacher teacher);

    /**
     * 更改老师信息
     *
     * @param teacher teacher
     */
    void updateTeacherByTeacherId(@Param("teacher") Teacher teacher);

    /**
     * 删除老师
     *
     * @param teacherId teacher id
     */
    void deleteTeacherByTeacherId(@Param("teacherId") BigInteger teacherId);
}
