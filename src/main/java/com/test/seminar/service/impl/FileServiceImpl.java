package com.test.seminar.service.impl;

import com.test.seminar.dao.CourseClassDao;
import com.test.seminar.dao.StudentDao;
import com.test.seminar.entity.Student;
import com.test.seminar.service.FileService;
import com.test.seminar.util.FileProcessor;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseClassDao courseClassDao;
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

    @Override
    public MultipartFile downloadFileByFilePath(String filePath) {
        return null;
    }
}
