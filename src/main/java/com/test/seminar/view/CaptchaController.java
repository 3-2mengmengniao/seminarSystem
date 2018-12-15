package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.*;
import com.test.seminar.service.*;
import com.test.seminar.exception.UserNotFoundException;
import com.test.seminar.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/forgetPassword",method = POST)
    @ResponseBody
    public String forgetPassword(String account,HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        String subject="验证码";
        String validation="123456";
        String email;
        try {
            Student student = studentService.getStudentByAccount(account);
            email=student.getEmail();
            session.setAttribute("usertype", "student");
            session.setAttribute("id", student.getId());
        }
        catch (UserNotFoundException e) {
            try {
                Teacher teacher = teacherService.getTeacherByAccount(account);
                email=teacher.getEmail();
                session.setAttribute("usertype", "teacher");
                session.setAttribute("id", teacher.getId());
            }
            catch (UserNotFoundException e2){
                String status = "409";
                return status;
            }
        }
        emailService.sendSimpleMessage(email,subject,validation);
        session.setAttribute("validation",validation);
        System.out.println(validation);
        String status = "200";
        return status;
    }

}
