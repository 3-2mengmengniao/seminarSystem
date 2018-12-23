package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseClassDao;
import com.test.seminar.dao.StudentDao;
import com.test.seminar.entity.CourseClass;
import com.test.seminar.entity.Student;
import com.test.seminar.exception.CourseClassNotFoundException;
import com.test.seminar.exception.RepetitiveRecordException;
import com.test.seminar.service.CourseClassService;
import com.test.seminar.util.FileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Service
public class CourseClassServiceImpl implements CourseClassService {
    @Autowired
    private CourseClassDao courseClassDao;
    @Autowired
    private StudentDao studentDao;
    @Override
    public CourseClass getCourseClassByCourseClassId(BigInteger courseClassId)throws CourseClassNotFoundException {
        return courseClassDao.getCourseClassByCourseClassId(courseClassId);
    }

    @Override
    public void insertCourseClass(CourseClass courseClass, BigInteger courseId)throws RepetitiveRecordException {
        courseClassDao.insertCourseClass(courseClass,courseId);
    }

    @Override
    public void updateCourseClassByCourseClass(CourseClass courseClass)throws CourseClassNotFoundException {
        courseClassDao.updateCourseClassByCourseClass(courseClass);
    }

    @Override
    public void deleteCourseClassByCourseClassId(BigInteger courseClassId)throws CourseClassNotFoundException {
        courseClassDao.deleteCourseClassByCourseClassId(courseClassId);
    }

    @Override
    public List<CourseClass> getCourseClassByCourseId(BigInteger courseId) {
        return courseClassDao.getCourseClassByCourseId(courseId);
    }

    @Override
    public CourseClass getCourseClassByStudentIdAndCourseId(BigInteger studentId, BigInteger courseId)throws CourseClassNotFoundException{
        return courseClassDao.getCourseClassByStudentIdAndCourseId(studentId,courseId);
    }

    @Override
    public void uploadStudentExcel(MultipartFile file, BigInteger courseClassId, BigInteger courseId) {
        //创建处理EXCEL
        FileProcessor readExcel=new FileProcessor();
        //解析excel，获取学生信息集合。
        List<Student> studentList = null;
        try {
            studentList = readExcel.getExcelInfo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(studentList != null) {
            //迭代添加学生信息
            for(Student student:studentList){
                Student studentWithId=studentDao.getStudentByAccount(student.getAccount());
                if(studentWithId==null)
                {
                    studentDao.insertStudent(student);
                    studentWithId=studentDao.getStudentByAccount(student.getAccount());
                }
                courseClassDao.insertCourseClassStudentRelation(courseClassId, studentWithId.getId(), courseId);
            }
        }
    }
}
