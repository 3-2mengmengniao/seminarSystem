package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Teacher;
import com.test.seminar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;


@Controller
public class HomeController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/", method = GET)
    public String login(Model model, String status) {
        if (status == null) {
        } else if (status.equals("401")) {
            model.addAttribute("message", "账号或密码错误");
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String loginPost(HttpServletRequest request,@RequestParam(value = "contactNameField") String account, @RequestParam(value = "contactEmailField") String password, Model model) {
        //获得session
        HttpSession session = request.getSession();
        //登陆验证
        Student student = loginService.studentLogin(account, password);
        if (student == null) {
            Teacher teacher = loginService.teacherLogin(account, password);
            if (teacher == null) {
                return "redirect:/?status=401";
            } else {
                session.setAttribute("usertype","teacher");
                session.setAttribute("account",teacher.getAccount());
                session.setAttribute("name",teacher.getName());
                return "redirect:/teacher/homepage";
            }
        } else {
            session.setAttribute("usertype","student");
            session.setAttribute("account",student.getAccount());
            session.setAttribute("name",student.getName());
            return "redirect:/student/homepage";
        }
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
