package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.dao.TeacherDao;
import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.*;
import com.test.seminar.entity.strategy.impl.CompositStrategy;
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
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private EmailService emailService;

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
    public void insertCourse(Course course, BigInteger teacherId) throws RepetitiveRecordException {
        courseDao.insertCourse(course, teacherId);
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
    public void updateShareTeamApplication(ShareTeamApplication shareTeamApplication){
        Teacher teacher=teacherDao.getTeacherByTeacherId(shareTeamApplication.getSubCourse().getTeacherId());
        String to=teacher.getEmail();
        String subject="共享组队请求反馈";
        String text="";
        //同意请求，编辑同意邮件
        if(shareTeamApplication.getStatus()==1){
            //更新从课程的主课程id
            courseDao.updateCourseTeamMainCourseId(shareTeamApplication.getSubCourse().getId(),shareTeamApplication.getMainCourse().getId());
            text=text+teacher.getTeacherName()+"同意了您对"+shareTeamApplication.getMainCourse().getCourseName()+"课程的共享分组请求";
        }
        //拒绝请求，编辑拒绝邮件
        else{
            text=text+teacher.getTeacherName()+"拒绝了您对"+shareTeamApplication.getMainCourse().getCourseName()+"课程的共享分组请求";
        }
        //发送邮件，删除共享请求
        emailService.sendSimpleMessage(to,subject,text);
        courseDao.deleteShareTeamApplication(shareTeamApplication.getId());
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
    public void updateShareSeminarApplication(ShareSeminarApplication shareSeminarApplication){
        Teacher teacher=teacherDao.getTeacherByTeacherId(shareSeminarApplication.getSubCourse().getTeacherId());
        String to=teacher.getEmail();
        String subject="共享组队请求反馈";
        String text="";
        //同意请求，编辑同意邮件
        if(shareSeminarApplication.getStatus()==1){
            //更新从课程的主课程id
            courseDao.updateCourseTeamMainCourseId(shareSeminarApplication.getSubCourse().getId(),shareSeminarApplication.getMainCourse().getId());
            text=text+teacher.getTeacherName()+"同意了您对"+shareSeminarApplication.getMainCourse().getCourseName()+"课程的共享讨论课请求";
        }
        //拒绝请求，编辑拒绝邮件
        else{
            text=text+teacher.getTeacherName()+"拒绝了您对"+shareSeminarApplication.getMainCourse().getCourseName()+"课程的共享讨论课请求";
        }
        //发送邮件，删除共享请求
        emailService.sendSimpleMessage(to,subject,text);
        courseDao.deleteShareTeamApplication(shareSeminarApplication.getId());
    }

    @Override
    public List<Course> getAllCourse(){
        return courseDao.getAllCourse();
    }
}
