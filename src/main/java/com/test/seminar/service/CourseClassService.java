package com.test.seminar.service;

import com.test.seminar.entity.CourseClass;
import com.test.seminar.exception.CourseClassNotFoundException;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.List;

/**
 * @author cxh
 * date 2018/11/30
 */
public interface CourseClassService {

    /**
     * 获取班级
     * @param courseClassId course class id
     * @throws CourseClassNotFoundException course class not found
     * @return CourseClass
     */
    CourseClass getCourseClassByCourseClassId(BigInteger courseClassId)throws CourseClassNotFoundException;

    /**
     * 插入班级
     *
     * @param courseClass course class
     * @param courseId course id
     * @param file file
     * @throws RepetitiveRecordException repetitive record found
     */
    void insertCourseClass(CourseClass courseClass, BigInteger courseId, MultipartFile file)throws RepetitiveRecordException;


    /**
     * 更新班级
     * @param courseClass course class
     * @throws CourseClassNotFoundException course class not found
     */
    void updateCourseClassByCourseClass( CourseClass courseClass) throws CourseClassNotFoundException;


    /**
     * 删除班级
     *
     * @param courseClassId course class id
     * @throws CourseClassNotFoundException course class not found
     */
    void deleteCourseClassByCourseClassId(BigInteger courseClassId)throws CourseClassNotFoundException;


    /**
     * 获取某课程下的所有班级
     * @param courseId course id
     * @return 班级列表
     */
    List<CourseClass> getCourseClassByCourseId(BigInteger courseId);

    /**
     * 通过学生和课程id获取学生该课程所在班级
     *
     * @param studentId student id
     * @param courseId course id
     * @return CourseClass
     * @throws CourseClassNotFoundException course class not found
     */

    CourseClass getCourseClassByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId)throws CourseClassNotFoundException;

    /**
     * 输入Excel文件导入学生，不会读取非excel文件
     *
     * @param file file
     * @param courseClassId course class id
     * @param courseId course id
     */
    void uploadStudentExcel(MultipartFile file, BigInteger courseClassId, BigInteger courseId);
}
