package com.test.seminar.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.UserNotFoundException;
import com.test.seminar.service.LoginService;
import com.test.seminar.service.StudentService;
import com.test.seminar.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;

/**
 * @author hatake
 * @date 2018/11/20
 */

@Controller
public class HomeController {
    @Autowired
    LoginService loginService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = {"/","/login"}, method = GET)
    public String login(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        session.invalidate();
            return "login";
    }

    @RequestMapping(value = "/forgetPassword", method = GET)
    public String forgetPassword(Model model) {
        return "forgetPassword";
    }

    @RequestMapping(value = "/forgetPassword", method = POST)
    @ResponseBody
    public String forgetPasswordPost(HttpServletRequest request,String account,String validation,Model model) {
        HttpSession session = request.getSession();
        //登陆验证
        try {
            Student student = studentService.getStudentByAccount(account);
            session.setAttribute("id", student.getId());
        }
        catch (UserNotFoundException e) {
            try {
                Teacher teacher = teacherService.getTeacherByAccount(account);
                session.setAttribute("id", teacher.getId());
            }
            catch (UserNotFoundException e2){
                String status = "404";
                return status;
            }
            String status = "200";
            return status;

        }
        String stauts="204";
        return stauts;
    }

    @RequestMapping(value = "/modifyPassword", method = GET)
    public String newPassword(Model model) {
        return "modifyPassword";
    }

    @RequestMapping(value = "/modifyPassword", method = POST)
    @ResponseBody
    public String newPasswordPost(HttpServletRequest request,@RequestParam(value = "newPsw") String newPsw,@RequestParam(value = "confirmPsw") String confirmPsw,Model model) {
        HttpSession session = request.getSession();
        String usertype = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().toLowerCase();
        String status="404";
        BigInteger teacherId;
        BigInteger studentId;
        if(usertype.equals("teacher"))
        {
            teacherId=(BigInteger)session.getAttribute("id");
            Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
            teacher.setPassword(newPsw);
            teacherService.updateTeacherByTeacherId(teacher);
            status="200";
            return status;
        }
        else if(usertype.equals("student"))
        {
            studentId=(BigInteger)session.getAttribute("id");
            Student student=studentService.getStudentByStudentId(studentId);
            student.setPassword(newPsw);
            studentService.updateStudentByStudentId(student);
            status="204";
            return status;
        }
        return status;
    }
}
