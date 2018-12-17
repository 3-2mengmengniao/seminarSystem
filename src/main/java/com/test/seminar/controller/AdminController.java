package com.test.seminar.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import java.math.BigInteger;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class AdminController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = {"/admin/","/admin/login"}, method = GET)
    public String login(HttpServletResponse response, Model model) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/login";
    }

    @RequestMapping(value ="/admin/index", method = GET)
    public String index(HttpServletResponse response,Model model) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/index";
    }

    @RequestMapping(value ="/admin/teacherList", method = GET)
    public String teacherList(HttpServletResponse response,Model model) {
        List<Teacher> teacherList=teacherService.getAllTeacher();
        model.addAttribute("teacherList",teacherList);
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/teacherList";
    }

    @RequestMapping(value ="/admin/studentList", method = GET)
    public String studentList(HttpServletResponse response,Model model) {
        List<Student> studentList=studentService.getAllStudent();
        model.addAttribute("studentList",studentList);
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/studentList";
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
        studentService.updateStudentByStudentId(studentOld);
        response.addHeader("x-frame-options","SAMEORIGIN");
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value ="/admin/student/{id}/resetPwd", method = POST)
    @ResponseBody
    public ResponseEntity<String> resetPwdStudent(@PathVariable BigInteger id,Model model) {
        Student student=studentService.getStudentByStudentId(id);
        student.setPassword("123456");
        studentService.updateStudentByStudentId(student);
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

}
