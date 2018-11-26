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


@Controller
public class HomeController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/", method = GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String loginPost(@RequestParam(value = "contactNameField") String account, @RequestParam(value = "contactEmailField") String password, Model model) {
        Student student = loginService.studentLogin(account, password);
        if (student == null) {
            Teacher teacher = loginService.teacherLogin(account, password);
            if (teacher == null) {
                model.addAttribute("message", "账号或密码错误");
                System.out.println("账号或密码错误");  //界面弄好注释
                return "login";
            } else {
                model.addAttribute("teacher", teacher);
                System.out.println(teacher.getName());  //界面弄好注释
                return "/teacher/homepage";
            }
        } else {
            System.out.println(student.getName());  //界面弄好注释
            model.addAttribute("student", student);
            return "/student/homepage";
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
