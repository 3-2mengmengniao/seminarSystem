package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.UserNotFoundException;
import com.test.seminar.service.LoginService;
import com.test.seminar.service.StudentService;
import com.test.seminar.service.TeacherService;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.math.BigInteger;


@Controller
public class HomeController {
    @Autowired
    LoginService loginService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/", method = GET)
    public String login(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        session.invalidate();
            return "login";
    }

    @RequestMapping(value = "/login", method = POST)
    @ResponseBody
    public String loginPost(HttpServletRequest request, @RequestParam(value = "contactNameField") String account, @RequestParam(value = "contactEmailField") String password, Model model)  {
        //获得session
        HttpSession session = request.getSession();
        //登陆验证
        try {
            Student student = loginService.studentLogin(account, password);
            session.setAttribute("usertype", "student");
            session.setAttribute("id", student.getId());
            session.setAttribute("account", student.getAccount());
            session.setAttribute("name", student.getStudentName());
            model.addAttribute("account", student.getAccount());
            model.addAttribute("name", student.getStudentName());
        }
       catch (UserNotFoundException e) {
            try {
                Teacher teacher = loginService.teacherLogin(account, password);
                session.setAttribute("usertype", "teacher");
                session.setAttribute("id", teacher.getId());
                session.setAttribute("account", teacher.getAccount());
                session.setAttribute("name", teacher.getTeacherName());
                model.addAttribute("account", teacher.getAccount());
                model.addAttribute("name", teacher.getTeacherName());
            }
            catch (UserNotFoundException e2){
                String status = "404";
                return status;
            }
           String status = "200";
           return status;

           }
        String status = "204";
        return status;
    }

    @RequestMapping(value = "/vali_psw", method = GET)
    public String valiPsw(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        String usertype=(String)session.getAttribute("usertype");
        model.addAttribute("usertype",usertype);
        return "vali_psw";
    }

    @RequestMapping(value = "/vali_psw", method = POST)
    @ResponseBody
    public String valiPswPost(HttpServletRequest request,@RequestParam(value = "newPsw") String newPsw,@RequestParam(value = "confirmPsw") String confirmPsw, @RequestParam(value = "validation") String validation,Model model) {
        HttpSession session = request.getSession();
        String usertype=(String)session.getAttribute("usertype");
        if(usertype.equals("teacher"))
        {
            BigInteger teacherId=(BigInteger)session.getAttribute("id");
            Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
            teacher.setPassword(newPsw);
            teacherService.updateTeacherByTeacherId(teacher);
            String status="200";
            return status;
        }
        else if(usertype.equals("student"))
        {
            BigInteger studentId=(BigInteger)session.getAttribute("id");
            Student student=studentService.getStudentByStudentId(studentId);
            student.setPassword(newPsw);
            studentService.updateStudentByStudentId(student);
            String status="204";
            return status;
        }
        String status="404";
        return status;
    }

    @RequestMapping(value = "/email-modify", method = POST)
    @ResponseBody
    public String emailModifyPost(HttpServletRequest request,@RequestParam(value = "email") String email, @RequestParam(value = "validation") String validation,Model model) {
        HttpSession session = request.getSession();
        String usertype=(String)session.getAttribute("usertype");
        if(usertype.equals("teacher"))
        {
            BigInteger teacherId=(BigInteger)session.getAttribute("id");
            Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
            teacher.setEmail(email);
            teacherService.updateTeacherByTeacherId(teacher);
            String status="200";
            return status;
        }
        else if(usertype.equals("student"))
        {
            BigInteger studentId=(BigInteger)session.getAttribute("id");
            Student student=studentService.getStudentByStudentId(studentId);
            student.setEmail(email);
            studentService.updateStudentByStudentId(student);
            String status="204";
            return status;
        }
        String status="404";
        return status;
    }

    @RequestMapping(value = "/email-modify", method = GET)
    public String emailModify(Model model) {
        return "email-modify";
    }

    @RequestMapping(value = "/forget_password", method = GET)
    public String forgetPassword(Model model) {
        return "forget_password";
    }

    @RequestMapping(value = "/forget_password", method = POST)
    @ResponseBody
    public String forgetPasswordPost(HttpServletRequest request,String account,String validation,Model model) {
        HttpSession session = request.getSession();
        //登陆验证
        try {
            Student student = studentService.getStudentByAccount(account);
            session.setAttribute("usertype", "student");
            session.setAttribute("id", student.getId());
        }
        catch (UserNotFoundException e) {
            try {
                Teacher teacher = teacherService.getTeacherByAccount(account);
                session.setAttribute("usertype", "teacher");
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

    @RequestMapping(value = "/new_password", method = GET)
    public String newPassword(Model model) {
        return "new_password";
    }

    @RequestMapping(value = "/new_password", method = POST)
    @ResponseBody
    public String newPasswordPost(HttpServletRequest request,@RequestParam(value = "newPsw") String newPsw,@RequestParam(value = "confirmPsw") String confirmPsw,Model model) {
        HttpSession session = request.getSession();
        String usertype=(String)session.getAttribute("usertype");
        String status="404";
        if(usertype.equals("teacher"))
        {
            BigInteger teacherId=(BigInteger)session.getAttribute("id");
            Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
            teacher.setPassword(newPsw);
            teacherService.updateTeacherByTeacherId(teacher);
            status="200";
            return status;
        }
        else if(usertype.equals("student"))
        {
            BigInteger studentId=(BigInteger)session.getAttribute("id");
            Student student=studentService.getStudentByStudentId(studentId);
            student.setPassword(newPsw);
            studentService.updateStudentByStudentId(student);
            status="204";
            return status;
        }
        return status;
    }
}
