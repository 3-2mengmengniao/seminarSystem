package com.test.seminar.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;

public interface FileService {
    /**
     * 输入Excel文件导入学生，不会读取非excel文件
     * @param file
     */
    void uploadStudentExcel(MultipartFile file);

    MultipartFile downloadFileByFilePath(String filePath);

    /**
     * 将某班级的学生信息导出为XSSF格式，可输出为.xlsx
     * @param courseClassId
     * @return
     */
    XSSFWorkbook downloadStudentListByCourseClassId(BigInteger courseClassId);
}
