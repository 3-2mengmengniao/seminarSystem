package com.test.seminar.dao.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.Course;
import com.test.seminar.entity.ShareSeminarApplication;
import com.test.seminar.entity.ShareTeamApplication;
import com.test.seminar.entity.Teacher;
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
        Teacher teacher=teacherMapper.getTeacherByTeacherId(course.getTeacherId());
        course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        if (course == null) {
            throw new CourseNotFoundException();
        }
        return course;
    }

    @Override
    public List<Course> getCourseByTeacherId(BigInteger teacherId) {
        List<Course> courseList=courseMapper.getCourseByTeacherId(teacherId);
        for(Course course:courseList){
            Teacher teacher=teacherMapper.getTeacherByTeacherId(course.getTeacherId());
            course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        }
        return courseList;
    }

    @Override
    public List<Course> getCourseByStudentId(BigInteger studentId) {
        List<Course> courseList=courseMapper.getCourseByStudentId(studentId);
        for(Course course:courseList){
            Teacher teacher=teacherMapper.getTeacherByTeacherId(course.getTeacherId());
            course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        }
        return courseList;
    }

    @Override
    public List<Course> getCourseBySeminarMainCourseId(BigInteger seminarMainCourseId) {
        List<Course> courseList=courseMapper.getCourseBySeminarMainCourseId(seminarMainCourseId);
        for(Course course:courseList){
            Teacher teacher=teacherMapper.getTeacherByTeacherId(course.getTeacherId());
            course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        }
        return courseList;
    }

    @Override
    public List<Course> getCourseByTeamMainCourseId(BigInteger teamMainCourseId) {
        List<Course> courseList=courseMapper.getCourseByTeamMainCourseId(teamMainCourseId);
        for(Course course:courseList){
            Teacher teacher=teacherMapper.getTeacherByTeacherId(course.getTeacherId());
            course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        }
        return courseList;
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
    public ShareTeamApplication getShareTeamApplicationByApplicationId(BigInteger applicationId){
        return courseMapper.getShareTeamApplicationByApplicationId(applicationId);
    }

    @Override
    public ShareSeminarApplication getShareSeminarApplicationByApplicationId(BigInteger applicationId){
        return courseMapper.getShareSeminarApplicationByApplicationId(applicationId);
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
        Course course = courseMapper.getMainCourseByShareSeminarApplicationId(shareSeminarApplicationId);
        Teacher teacher=teacherMapper.getTeacherByTeacherId(course.getTeacherId());
        course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        return course;
    }

    @Override
    public Course getSubCourseByShareSeminarApplicationId(BigInteger shareSeminarApplicationId){
        Course course = courseMapper.getSubCourseByShareSeminarApplicationId(shareSeminarApplicationId);
        Teacher teacher=teacherMapper.getTeacherByTeacherId(course.getTeacherId());
        course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        return course;
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
    public  List<Course> getAllCourse(){
        List<Course> courseList=courseMapper.getAllCourse();
        for(Course course:courseList){
            course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        }
        return courseList;
    }

    @Override
    public List<Course> getAvailableCourseForShare(BigInteger courseId){
        List<Course> courseList=courseMapper.getAvailableCourseForShare(courseId);
        for(Course course:courseList){
            course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        }
        return courseList;
    }

    @Override
    public  Course getCourseByRoundId(BigInteger roundId){
        Course course = courseMapper.getCourseByRoundId(roundId);
        Teacher teacher=teacherMapper.getTeacherByTeacherId(course.getTeacherId());
        course.setCourseName(course.getCourseName()+'('+teacherMapper.getTeacherByTeacherId(course.getTeacherId()).getTeacherName()+')');
        return course;
    }
}
