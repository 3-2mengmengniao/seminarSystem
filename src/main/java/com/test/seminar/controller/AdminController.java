package com.test.seminar.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.service.StudentService;
import com.test.seminar.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;
/**
 * @author hatake
 * @date 2018/12/12
 */
@Controller
public class AdminController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = {"/admin/","/admin/login"}, method = GET)
    public String login(Model model) {
        return "admin/login";
    }

    @RequestMapping(value ="/admin/index", method = GET)
    public String index(HttpServletResponse response,Model model) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/index";
    }

    @RequestMapping(value ="/admin/editTeacher", method = GET)
    public String editTeacher(HttpServletResponse response, BigInteger teacherId, Model model) {
        Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
        model.addAttribute("teacher",teacher);
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/editTeacher";
    }

    @RequestMapping(value ="/admin/editStudent", method = GET)
    public String editStudent(HttpServletResponse response, BigInteger studentId, Model model) {
        Student student=studentService.getStudentByStudentId(studentId);
        model.addAttribute("student",student);
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/editStudent";
    }

    @RequestMapping(value ="/admin/teacher/edit", method = PATCH)
    @ResponseBody
    public ResponseEntity<String> editTeacherPost(HttpServletResponse response,BigInteger id,Teacher teacherNew, Model model) {
        Teacher teacherOld=teacherService.getTeacherByTeacherId(id);
        teacherOld.setPassword(teacherNew.getPassword());
        teacherOld.setEmail(teacherNew.getEmail());
        teacherOld.setAccount(teacherNew.getAccount());
        teacherOld.setTeacherName(teacherNew.getTeacherName());
        teacherService.updateTeacherByTeacherId(teacherOld);
        response.addHeader("x-frame-options","SAMEORIGIN");
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value ="/admin/student/edit", method = PATCH)
    @ResponseBody
    public ResponseEntity<String> editStudentPost(HttpServletResponse response,BigInteger id,Student studentNew, Model model) {
        Student studentOld=studentService.getStudentByStudentId(id);
        studentOld.setPassword(studentNew.getPassword());
        studentOld.setEmail(studentNew.getEmail());
        studentOld.setAccount(studentNew.getAccount());
        studentOld.setStudentName(studentNew.getStudentName());
        studentService.updateStudentByStudent(studentOld);
        response.addHeader("x-frame-options","SAMEORIGIN");
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value ="/admin/student/{id}/resetPwd", method = POST)
    @ResponseBody
    public ResponseEntity<String> resetPwdStudent(@PathVariable BigInteger id,Model model) {
        Student student=studentService.getStudentByStudentId(id);
        student.setPassword("123456");
        studentService.updateStudentByStudent(student);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value ="/admin/teacher/{id}/resetPwd", method = POST)
    @ResponseBody
    public ResponseEntity<String> resetPwdTeacher(@PathVariable BigInteger id,Model model) {
        Teacher teacher=teacherService.getTeacherByTeacherId(id);
        teacher.setPassword("123456");
        teacherService.updateTeacherByTeacherId(teacher);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value ="/admin/teacher/{id}", method = DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteTeacher(@PathVariable BigInteger id,Model model) {
        teacherService.deleteTeacherByTeacherId(id);
        System.out.println("success");
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value ="/admin/student/{id}", method = DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteStudent(@PathVariable BigInteger id,Model model) {
       studentService.deleteStudentByStudentId(id);
        System.out.println("success");
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value ="/admin/addTeacher", method = GET)
    public String addTeacher(HttpServletResponse response,Model model) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/addTeacher";
    }

    @RequestMapping(value ="/admin/teacher", method = PUT)
    @ResponseBody
    public ResponseEntity<String> addTeacherPost(Teacher teacher,Model model) {
        teacher.setActive(0);
        teacherService.insertTeacher(teacher);
        System.out.println("success");
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/teacherList")
    public String teacherList(Model model,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
                          @RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
        PageInfo<Teacher> pageInfo = teacherService.selectTeacherList(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/teacherList";
    }

    @RequestMapping(value = "/admin/studentList")
    public String studentList(Model model,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
                              @RequestParam(value="pageSize",defaultValue="10") Integer pageSize){
        PageInfo<Student> pageInfo = studentService.selectStudentList(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/studentList";
    }

}
