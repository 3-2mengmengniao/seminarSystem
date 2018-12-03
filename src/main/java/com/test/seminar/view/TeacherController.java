package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.*;
import com.test.seminar.exception.SeminarControlNotFoundException;
import com.test.seminar.service.*;
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

    @Autowired
    CourseClassService courseClassService;

    @Autowired
    TeacherService teacherService;

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
    public String security(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
        model.addAttribute("teacher",teacher);
        return "teacher/security";
    }

    @RequestMapping(value="/class-info")
    public String classInfo(HttpServletRequest request,BigInteger courseId,Model model) {
        HttpSession session = request.getSession();
        List<CourseClass> courseClasses=courseClassService.getCourseClassByCourseId(courseId);
        model.addAttribute("courseClassList",courseClasses);
        session.setAttribute("courseId",courseId);
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

    @RequestMapping(value="/create-class",method = GET)
    public String createClass(Model model) { return "teacher/create-class"; }

    @RequestMapping(value="/create-class",method = POST)
    @ResponseBody
    public String createClassPost(HttpServletRequest request,Model model,CourseClass courseClass) {
        HttpSession session = request.getSession();
        BigInteger courseId=(BigInteger)session.getAttribute("courseId");
        courseClass.setCourseId(courseId);
        courseClassService.insertCourseClass(courseClass);
        String status="200";
        return status;
    }

    @RequestMapping(value="/courses/class",method = DELETE)
    @ResponseBody
    public String classDelete(BigInteger classId, Model model) {
        courseClassService.deleteCourseClassByCourseClassId(classId);
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
        model.addAttribute("seminarList",seminarList);
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        List<CourseClass> courseClasses=courseClassService.getCourseClassByCourseId(courseId);
        model.addAttribute("courseClassList",courseClasses);
        return "teacher/course-seminar";
    }

    @RequestMapping(value="/teams")
    public String teams(Model model) {
        return "teacher/teams";
    }

    @RequestMapping(value="/seminar_info")
    public String seminarInfo(BigInteger courseId, BigInteger classId,BigInteger seminarId, Model model) {
            SeminarControl seminarControl = seminarService.getSemniarControlByClassIdAndSeminarInfoId(classId, seminarId);
            SeminarInfo seminarInfo=seminarService.getSeminarBySeminarId(seminarId);
            model.addAttribute("seminarInfo",seminarInfo);
            BigInteger roundId=seminarInfo.getRoundId();
            Round round=roundService.getRoundByRoundId(roundId);
            model.addAttribute("round",round);
            Course course=courseService.getCourseByCourseId(courseId);
            model.addAttribute("course",course);
            if(seminarControl.getSeminarStatus().equals("UNSTARTED"))
                return "teacher/seminar_info_ready";
            else if(seminarControl.getSeminarStatus().equals("INPROCESS"))
                return "teacher/seminar_info_begin";
            else if(seminarControl.getSeminarStatus().equals("FINISHED"))
                return "teacher/seminar_info_complete";
            else
            return "error";
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
