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
     * @param teacherId
     * @return
     */
    Teacher getTeacherByTeacherId(@Param("teacherId") BigInteger teacherId);

    /**
     * 通过account获取教师信息
     *
     * @param account
     * @return
     */
    Teacher getTeacherByAccount(String account);

    /**
     * 创建新的老师账户
     *
     * @param teacher
     * @return
     */
    void insertTeacher(@Param("teacher") Teacher teacher);

    /**
     * 更改老师信息
     *
     * @param teacher
     * @return
     */
    void updateTeacherByTeacherId(@Param("teacher") Teacher teacher);

    /**
     * 删除老师
     *
     * @param teacherId
     * @return
     */
    void deleteTeacherByTeacherId(@Param("teacherId") BigInteger teacherId);

    /**
     * @return
     */
    List<Teacher> getAllTeacher();
}
