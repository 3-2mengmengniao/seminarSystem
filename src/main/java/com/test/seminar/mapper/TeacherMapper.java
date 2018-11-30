package com.test.seminar.mapper;


import com.test.seminar.entity.Teacher;
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
public interface TeacherMapper {
    /**
     * 通过ID获取老师信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherByTeacherId(BigInteger teacherId);

    /**
     * 创建新的老师账户
     * @param teacher
     * @return
     */
    void insertTeacher(Teacher teacher);

    /**
     * 更改老师信息
     * @param teacher
     * @return
     */
    void updateTeacherByTeacherId(Teacher teacher);

    /**
     * 删除老师
     * @param teacherId
     * @return
     */
    void deleteTeacherByTeacherId(BigInteger teacherId);
}
