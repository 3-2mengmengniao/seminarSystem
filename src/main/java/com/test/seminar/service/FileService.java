package com.test.seminar.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;

public interface FileService {
    /**
     * 输入Excel文件导入学生，不会读取非excel文件
     * @param file
     */
    @Transactional
    void uploadStudentExcel(MultipartFile file, BigInteger courseClassId, BigInteger courseId);

    MultipartFile downloadFileByFilePath(String filePath);
}
