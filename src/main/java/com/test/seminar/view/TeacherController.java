package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.Course;
import com.test.seminar.entity.Round;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarInfo;
import com.test.seminar.service.CourseService;
import com.test.seminar.service.RoundService;
import com.test.seminar.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    CourseService courseService;

    @Autowired
    RoundService roundService;

    @Autowired
    SeminarService seminarService;

    @RequestMapping(value="/homepage")
    public String home(Model model) {
        return "teacher/homepage";
    }

    @RequestMapping(value="/courses",method = GET)
    public String courses(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        List<Course> courseList= courseService.getCourseByTeacherId(teacherId);
        model.addAttribute("courseList",courseList);
        return "teacher/courses";
    }

    @RequestMapping(value="/courses",method = DELETE)
    @ResponseBody
    public String courseDelete(BigInteger courseId, Model model) {
        courseService.deleteCourseByCourseId(courseId);
        String status="200";
        return status;
    }

    @RequestMapping(value="/security",method = GET)
    public String security(Model model) {
        return "teacher/security";
    }

    @RequestMapping(value="/class-info")
    public String classInfo(Model model) {
        return "teacher/class-info";
    }

    @RequestMapping(value="/course-info")
    public String courseInfo(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        return "teacher/course-info";
    }

    @RequestMapping(value="/create-course",method = GET)
    public String createCourse(Model model) {
        return "teacher/create-course";
    }

    @RequestMapping(value="/create-course",method = POST)
    @ResponseBody
    public String createCoursePost(HttpServletRequest request,Model model,Course course) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        course.setTeacherId(teacherId);

        courseService.insertCourse(course);
        String status="200";
        return status;
    }

    @RequestMapping(value="/group-score")
    public String groupScore(Model model) {
        return "teacher/group-score";
    }

    @RequestMapping(value="/seminars")
    public String seminars(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        List<Course> courseList= courseService.getCourseByTeacherId(teacherId);
        model.addAttribute("courseList",courseList);
        return "teacher/seminars";
    }

    @RequestMapping(value="/course-seminar")
    public String courseSeminar(BigInteger courseId,Model model) {
        List<Round> roundList= roundService.getRoundByCourseId(courseId);
        model.addAttribute("roundList",roundList);
        List<List<SeminarInfo>> seminarList = seminarService.getSeminarInfoByRoundList(roundList);
        for(int i=0;i<seminarList.size();i++) {
            System.out.println(seminarList.get(i).size());
        }
        model.addAttribute("seminarList",seminarList);
        return "teacher/course-seminar";
    }

    @RequestMapping(value="/teams")
    public String teams(Model model) {
        return "teacher/teams";
    }

    @RequestMapping(value="/seminar_info_end")
    public String seminarInfoEnd(Model model) {
        return "teacher/seminar_info_end";
    }

    @RequestMapping(value="/seminar_info_begin")
    public String seminarInfoBegin(Model model) {
        return "teacher/seminar_info_begin";
    }

    @RequestMapping(value="/report_download")
    public String reportDownload(Model model) {
        return "teacher/report_download";
    }

    @RequestMapping(value="/report_score")
    public String reportScore(Model model) {
        return "teacher/report_score";
    }
}
