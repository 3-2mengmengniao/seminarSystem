package com.test.seminar.mapper;

import com.test.seminar.entity.Admin;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author zhenweiwang
 * @date 2018/11/26
 */
@Mapper
@Component
public interface LoginMapper {
    /**
     * 根据账号密码查询学生
     *
     * @param account   账号
     * @param password  密码
     * @return com.test.seminar.entity.Student
     */
    Student studentLogin(@Param("account") String account, @Param("password") String password);

    /**
     * 根据账号密码查询老师
     *
     * @param account   账号
     * @param password  密码
     * @return com.test.seminar.entity.Teacher
     */
    Teacher teacherLogin(@Param("account") String account, @Param("password") String password);

    /**
     * 根据账号密码查询管理员
     *
     * @param account   账号
     * @param password  密码
     * @return com.test.seminar.entity.Admin
     */
    Admin adminLogin(@Param("account") String account, @Param("password") String password);

}
