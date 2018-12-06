package com.test.seminar.util;

import com.test.seminar.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadExcel {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public ReadExcel(){}
    //获取总行数
    public int getTotalRows()  { return totalRows;}
    //获取总列数
    public int getTotalCells() {  return totalCells;}
    //获取错误信息
    public String getErrorInfo() { return errorMsg; }

    /**
     * 验证EXCEL文件
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath){
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))){
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    /**
     * 读EXCEL文件，获取客户信息集合
     * @param mFile
     * @return
     */
    public List<Student> getExcelInfo(MultipartFile mFile) throws IOException {
        //初始化客户信息的集合
        List<Student> studentList=new ArrayList<Student>();
        //初始化输入流
        File convFile = new File(mFile.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(mFile.getBytes());
        fos.close();
        try{
            //验证文件名是否合格
            if(!validateExcel(convFile.getName())){
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if(isExcel2007(convFile.getName())){
                isExcel2003 = false;
            }
            //根据新建的文件实例化输入流
            //根据excel里面的内容读取客户信息
            studentList = getExcelInfo(convFile, isExcel2003);
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(fos !=null)
            {
                try{
                    fos.close();
                }catch(IOException e){
                    fos = null;
                    e.printStackTrace();
                }
            }
        }
        return studentList;
    }
    /**
     * 根据excel里面的内容读取客户信息
     * @param is 输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public  List<Student> getExcelInfo(File file,boolean isExcel2003){
        List<Student> studentList=null;
        try{
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            //当excel是2003时
            if(isExcel2003){
                POIFSFileSystem poiFile = new POIFSFileSystem(file);
                wb = new HSSFWorkbook(poiFile);
            }
            else{//当excel是2007时
                try {
                    wb = new XSSFWorkbook(file);
                } catch (InvalidFormatException e) {
                    e.printStackTrace();
                }
            }
            //读取Excel里面客户的信息
            studentList=readExcelValue(wb);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }
        return studentList;
    }
    /**
     * 读取Excel里面客户的信息
     * @param wb
     * @return
     */
    private List<Student> readExcelValue(@NotNull Workbook wb){
        //得到第一个shell
        Sheet sheet=wb.getSheetAt(0);

        //得到Excel的行数
        this.totalRows=sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if(totalRows>=1 && sheet.getRow(0) != null){
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<Student> studentList=new ArrayList<Student>();
        Student student;
        //循环Excel行数,从第二行开始。标题不入库
        for(int r=1;r<totalRows;r++){
            Row row = sheet.getRow(r);
            if (row == null) continue;
            student = new Student();

            //循环Excel的列
            for(int c = 0; c <this.totalCells; c++){
                Cell cell = row.getCell(c);
                if (null != cell){
                    if(c==0){
                        student.setAccount(cell.getStringCellValue());
                    }else if(c==1){
                        student.setStudentName(cell.getStringCellValue());
                    }else if(c==2){
                        student.setEmail(cell.getStringCellValue());
                    }
                }
            }
            //添加客户
            studentList.add(student);
        }
        return studentList;
    }

    // @描述：是否是2003的excel，返回true是2003
    private boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    private boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

}