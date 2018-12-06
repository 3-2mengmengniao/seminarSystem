package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.Course;
import com.test.seminar.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/homepage")
    public String home(Model model) {
        return "student/homepage";
    }


    @RequestMapping(value = "/courses", method = GET)
    public String courses(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        List<Course> courseList= courseService.getCourseByStudentId(studentId);
        model.addAttribute("courseList",courseList);
        return "student/courses";
    }

    @RequestMapping(value = "/security", method = GET)
    public String security(Model model) {
        return "student/security";
    }

    @RequestMapping(value = "/seminars")
    public String seminars(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        List<Course> courseList= courseService.getCourseByStudentId(studentId);
        model.addAttribute("courseList",courseList);
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

    @RequestMapping(value = "/seminar_info_begin")
    public String seminarInfoBegin(Model model) {
        return "student/seminar_info_begin";
    }

    @RequestMapping(value = "/seminar_info_ready")
    public String seminarInfoReady(Model model) {
        return "student/seminar_info_ready";
    }

    @RequestMapping(value = "/seminar_info_complete")
    public String seminarInfoComplete(Model model) {
        return "student/seminar_info_Complete";
    }

    @RequestMapping(value = "/begin_enrollment")
    public String beginEnrollment(Model model) {
        return "student/begin_enrollment";
    }

    @RequestMapping(value = "/complete_enrollment")
    public String completeEnrollment(Model model) {
        return "student/complete_enrollment";
    }

    @RequestMapping(value = "/ready_enrollment")
    public String readyEnrollment(Model model) {
        return "student/ready_enrollment";
    }

    @RequestMapping(value = "/begin_present")
    public String beginPresent(Model model) {
        return "student/begin_present";
    }

    @RequestMapping(value = "/selected_seminar_homepage")
    public String selectedSeminarHomepage(Model model) {
        return "student/selected_seminar_homepage";
    }

    @RequestMapping(value = "/selected_seminar_enrollment")
    public String selectedSeminarEnrollment(Model model) {
        return "student/selected_seminar_enrollment";
    }

    @RequestMapping(value = "/selected_seminar_info")
    public String selectedSeminarInfo(Model model) { return "student/selected_seminar_info"; }

    @RequestMapping(value = "/score")
    public String score(Model model) { return "student/score"; }

    @RequestMapping(value = "/seminar_end")
    public String seminarEnd(Model model) { return "student/seminar_end"; }

    @RequestMapping(value="/course-info")
    public String courseInfo(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        return "student/course-info";
    }
}
