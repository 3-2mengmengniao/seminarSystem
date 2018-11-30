package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping(value = "/homepage")
    public String home(Model model) {
        return "student/homepage";
    }

    @RequestMapping(value = "/courses", method = GET)
    public String courses(Model model) {
        return "student/courses";
    }

    @RequestMapping(value = "/security", method = GET)
    public String security(Model model) {
        return "student/security";
    }

    @RequestMapping(value = "/seminars")
    public String seminars(Model model) {
        return "student/seminars";
    }

    @RequestMapping(value = "/course-seminar")
    public String courseSeminar(Model model) {
        return "student/course-seminar";
    }

    @RequestMapping(value = "/teams")
    public String teams(Model model) {
        return "student/teams";
    }

    @RequestMapping(value = "/group-score")
    public String groupScore(Model model) {
        return "student/group-score";
    }

    @RequestMapping(value = "/seminar_info_end")
    public String seminarInfoEnd(Model model) {
        return "student/selected_seminar_homepage";
    }

    @RequestMapping(value = "/seminar_info_begin")
    public String seminarInfoBegin(Model model) {
        return "student/seminar_info_begin";
    }
}
