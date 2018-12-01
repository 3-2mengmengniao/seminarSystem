package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.exception.UserNotFoundException;
import com.test.seminar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;


@Controller
public class HomeController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/", method = GET)
    public String login(Model model) {
        //获得session
//        HttpSession session = request.getSession();
//        String status = (String) session.getAttribute("status");
//        if (status == null) {
//            return "login";
//        } else if (status.equals("401")) {
//            model.addAttribute("message", "账号或密码有误，请重新输入！");
//            session.setAttribute("status", null);
//            return "redirect:/login";
//        } else {
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
    public String valiPsw(Model model) {
        return "vali_psw";
    }

    @RequestMapping(value = "/email-modify", method = GET)
    public String emailModify(Model model) {
        return "email-modify";
    }

}
