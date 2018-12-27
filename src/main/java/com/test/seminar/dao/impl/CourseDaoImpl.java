package com.test.seminar.dao.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.ShareSeminarApplication;
import com.test.seminar.entity.ShareTeamApplication;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.ShareTeamApplicationNotFoundException;
import com.test.seminar.mapper.CourseMapper;
import com.test.seminar.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.List;

/**
 * @author zhenweiwang
 * @date 2018/11/29
 */
@Component
public class CourseDaoImpl implements CourseDao {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    CourseDao courseDao;

    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        Course course = courseMapper.getCourseByCourseId(courseId);
        if (course == null) {
            throw new CourseNotFoundException();
        }
        return course;
    }

    @Override
    public List<Course> getCourseByTeacherId(BigInteger teacherId) {
        return courseMapper.getCourseByTeacherId(teacherId);
    }

    @Override
    public List<Course> getCourseByStudentId(BigInteger studentId) {
        return courseMapper.getCourseByStudentId(studentId);
    }

    @Override
    public List<Course> getCourseBySeminarMainCourseId(BigInteger seminarMainCourseId) {
        return courseMapper.getCourseBySeminarMainCourseId(seminarMainCourseId);
    }

    @Override
    public List<Course> getCourseByTeamMainCourseId(BigInteger teamMainCourseId) {
        return courseMapper.getCourseByTeamMainCourseId(teamMainCourseId);
    }

    @Override
    public void insertCourse(Course course, BigInteger teacherId) throws RepetitiveRecordException {
        courseMapper.insertCourse(course, teacherId);
    }

    @Override
    public void updateCourseByCourseId(Course course) throws CourseNotFoundException {
        courseMapper.updateCourseByCourseId(course);
    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        Course course = courseMapper.getCourseByCourseId(courseId);
        if (course == null) {
            throw new CourseNotFoundException();
        }
        courseMapper.deleteCourseByCourseId(courseId);
    }

    @Override
    public void insertShareTeamApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId) {
        courseMapper.insertShareTeamApplication(mainCourseId,subCourseId,subCourseTeacherId);
    }

    @Override
    public void deleteShareTeamApplication(BigInteger shareTeamApplicationId) {
        courseMapper.deleteShareTeamApplication(shareTeamApplicationId);
    }

    @Override
    public List<ShareTeamApplication> getShareTeamApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId) throws ShareTeamApplicationNotFoundException {
        List<ShareTeamApplication> shareTeamApplication=courseMapper.getShareTeamApplicationBySubCourseTeacherId(subCourseTeacherId);
        if(shareTeamApplication==null){
            throw new ShareTeamApplicationNotFoundException();
        }
        return shareTeamApplication;
    }

    @Override
    public List<ShareSeminarApplication> getShareSeminarApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId){
        return courseMapper.getShareSeminarApplicationBySubCourseTeacherId(subCourseTeacherId);
    }

    @Override
    public Course getMainCourseByShareSeminarApplicationId(BigInteger shareSeminarApplicationId){
        return courseMapper.getMainCourseByShareSeminarApplicationId(shareSeminarApplicationId);
    }

    @Override
    public Course getSubCourseByShareSeminarApplicationId(BigInteger shareSeminarApplicationId){
        return courseMapper.getSubCourseByShareSeminarApplicationId(shareSeminarApplicationId);
    }

    @Override
    public void insertShareSeminarApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId){
        courseMapper.insertShareSeminarApplication(mainCourseId,subCourseId,subCourseTeacherId);
    }

    @Override
    public void createShareTeamAssociation(ShareTeamApplication shareTeamApplication) {
        BigInteger subCourseId=shareTeamApplication.getSubCourse().getId();
        BigInteger mainCourseId=shareTeamApplication.getMainCourse().getId();
        courseMapper.updateCourseTeamMainCourseId(subCourseId,mainCourseId);
    }

    @Override
    public void updateCourseTeamMainCourseId(BigInteger subCourseId,BigInteger mainCourseId){
        courseMapper.updateCourseTeamMainCourseId(subCourseId,mainCourseId);
    }

    @Override
    public void updateCourseSeminarMainCourseId(BigInteger subCourseId,BigInteger mainCourseId){
        courseMapper.updateCourseSeminarMainCourseId(subCourseId,mainCourseId);
    }

    @Override
    public List<Course> getAllCourse(){
        List<Course> courseList=courseMapper.getAllCourse();
        for(Course course:courseList){
            course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        }
        return courseList;
    }
}
