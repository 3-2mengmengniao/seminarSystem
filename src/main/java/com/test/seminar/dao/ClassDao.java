package com.test.seminar.dao;

import com.test.seminar.entity.CourseClass;

import java.math.BigInteger;
import java.util.List;

public interface ClassDao {

    /**
     * 通过ID获取班级信息
     * @param courseClassId
     * @return
     */
    CourseClass getCourseClassByCourseClassId(BigInteger courseClassId);

    /**
     * 创建新的班级账户
     * @param courseClass
     * @return 新建班级的ID
     */
    void insertCourseClass(CourseClass courseClass);

    /**
     * 根据班级ID更改班级信息
     * @param courseClassId
     * @param courseClass
     * @return
     */
    void updateCourseClassByCourseClassId(BigInteger courseClassId, CourseClass courseClass);

    /**
     *
     * @param courseClassId
     * @return
     */
    void deleteCourseClassByCourseClassId(BigInteger courseClassId);

    /**
     * 获取某课程下的所有班级
     * @param courseId
     * @return
     */
    List<Class> getCourseClassByCourseId(BigInteger courseId);


}
