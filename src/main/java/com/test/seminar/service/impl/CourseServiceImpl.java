package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.dao.TeacherDao;
import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.*;
import com.test.seminar.entity.strategy.impl.CompositStrategy;
import com.test.seminar.entity.strategy.impl.ConflictCourseStrategy;
import com.test.seminar.entity.strategy.impl.CourseMemberLimitStrategy;
import com.test.seminar.entity.strategy.impl.MemberLimitStrategy;
import com.test.seminar.exception.CourseNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.exception.ShareTeamApplicationNotFoundException;
import com.test.seminar.exception.TeamNotFoundException;
import com.test.seminar.service.CourseService;
import com.test.seminar.entity.strategy.TeamStrategy;
import com.test.seminar.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private TeamDao teamDao;

    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        return courseDao.getCourseByCourseId(courseId);
    }

    @Override
    public List<Course> getCourseByTeacherId(BigInteger teacherId) {
        return courseDao.getCourseByTeacherId(teacherId);
    }

    @Override
    public List<Course> getCourseByStudentId(BigInteger studentId) {
        return courseDao.getCourseByStudentId(studentId);
    }

    @Override
    public void insertCourse(Course course, BigInteger teacherId, List<ConflictCourseStrategy> conflictCourseStrategyArrayList, List<CourseMemberLimitStrategy> courseMemberLimitStrategyList, MemberLimitStrategy thisCourse, Integer choose)throws RepetitiveRecordException{
        courseDao.insertCourse(course,teacherId);
        course=courseDao.getCourseByCourseNameAndTeacherId(course.getCourseName(),teacherId);
        teamDao.insetTeamStrategy(course.getId(),conflictCourseStrategyArrayList, courseMemberLimitStrategyList, thisCourse, choose);
    }

    @Override
    public void updateCourseByCourseId(Course course) throws CourseNotFoundException {
        courseDao.updateCourseByCourseId(course);
    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId) throws CourseNotFoundException {
        courseDao.deleteCourseByCourseId(courseId);
    }

    @Override
    public void insertShareTeamApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId){
        courseDao.insertShareTeamApplication(mainCourseId,subCourseId,subCourseTeacherId);
    }

    @Override
    public List<ShareTeamApplication> getShareTeamApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId) throws ShareTeamApplicationNotFoundException {
        return courseDao.getShareTeamApplicationBySubCourseTeacherId(subCourseTeacherId);
    }

    @Override
    public void insertShareSeminarApplication(BigInteger mainCourseId,BigInteger subCourseId,BigInteger subCourseTeacherId){
        courseDao.insertShareSeminarApplication(mainCourseId,subCourseId,subCourseTeacherId);
    }

    @Override
    public List<ShareSeminarApplication> getShareSeminarApplicationBySubCourseTeacherId(BigInteger subCourseTeacherId){
        return courseDao.getShareSeminarApplicationBySubCourseTeacherId(subCourseTeacherId);
    }

    @Override
    public List<Course> getAllCourse(){
        return courseDao.getAllCourse();
    }

    @Override
    public List<Course> getAvailableCourseForShare(BigInteger courseId){
        return courseDao.getAvailableCourseForShare(courseId);
    }

    @Override
    public ShareTeamApplication getShareTeamApplicationByApplicationId(BigInteger applicationId){
        return  courseDao.getShareTeamApplicationByApplicationId(applicationId);
    }

    @Override
    public ShareSeminarApplication getShareSeminarApplicationByApplicationId(BigInteger applicationId){
        return  courseDao.getShareSeminarApplicationByApplicationId(applicationId);
    }

    @Override
    public void deleteShareTeamApplication(BigInteger shareTeamApplicationId){
        courseDao.deleteShareTeamApplication(shareTeamApplicationId);
    }

    @Override
    public void deleteShareSeminarApplication(BigInteger shareSeminarApplicationId){
        courseDao.deleteShareSeminarApplication(shareSeminarApplicationId);
    }
}
