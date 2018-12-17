package com.test.seminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AdminController {

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
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/teacherList";
    }

    @RequestMapping(value ="/admin/studentList", method = GET)
    public String studentList(HttpServletResponse response,Model model) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/studentList";
    }

    @RequestMapping(value ="/admin/editTeacher", method = GET)
    public String editTeacher(HttpServletResponse response,Model model) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/editTeacher";
    }

    @RequestMapping(value ="/admin/editStudent", method = GET)
    public String editStudent(HttpServletResponse response,Model model) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/editStudent";
    }

    @RequestMapping(value ="/admin/addTeacher", method = GET)
    public String addTeacher(HttpServletResponse response,Model model) {
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/addTeacher";
    }

}
