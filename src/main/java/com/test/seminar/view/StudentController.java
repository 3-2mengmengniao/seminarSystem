package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.dao.CourseDao;
import com.test.seminar.entity.*;
import com.test.seminar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    CourseService courseService;

    @Autowired
    RoundService roundService;

    @Autowired
    SeminarService seminarService;

    @Autowired
    CourseClassService courseClassService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeamService teamService;

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
    public String security(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Student student=studentService.getStudentByStudentId(studentId);
        model.addAttribute("student",student);
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
    public String courseSeminar(BigInteger courseId, HttpServletRequest request,Model model) {
        List<Round> roundList= roundService.getRoundByCourseId(courseId);
        model.addAttribute("roundList",roundList);
        List<List<SeminarInfo>> seminarList = seminarService.getSeminarInfoByRoundList(roundList);
        model.addAttribute("seminarList",seminarList);
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        model.addAttribute("studentId",studentId);
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        CourseClass myClass = courseClassService.getCourseClassByStudentIdAndCourseId(studentId, courseId);
        model.addAttribute("class",myClass);
        return "student/course-seminar";
    }

    @RequestMapping(value = "/teams")
    public String teams(HttpServletRequest request,BigInteger courseId,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        model.addAttribute("courseId",courseId);
        List<Team> teamList= teamService.getTeamByCourseId(courseId);
        model.addAttribute("teamList",teamList);
        List<List<Student>> studentList=new LinkedList<List<Student>>();
        List<Student> leaderList=new ArrayList();
        for( int i = 0 ; i < teamList.size() ; i++) {
            BigInteger teamId=teamList.get(i).getId();
            List<Student> teamStudents= studentService.getStudentByTeamId(teamId);
            Student leader=studentService.getStudentByStudentId(teamList.get(i).getLeaderId());
            leaderList.add(leader);
            studentList.add(teamStudents);
        }
        model.addAttribute("studentList",studentList);
        model.addAttribute("leaderList",leaderList);
        return "student/teams";
    }

    @RequestMapping(value = "/group-score")
    public String groupScore(Model model) {
        return "student/group-score";
    }

    @RequestMapping(value="/seminar_info")
    public String seminarInfo(HttpServletRequest request,BigInteger courseId, BigInteger classId,BigInteger seminarId, Model model) {
        SeminarControl seminarControl = seminarService.getSemniarControlByClassIdAndSeminarInfoId(classId, seminarId);
        SeminarInfo seminarInfo=seminarService.getSeminarBySeminarId(seminarId);
        model.addAttribute("seminarInfo",seminarInfo);
        BigInteger roundId=seminarInfo.getRoundId();
        Round round=roundService.getRoundByRoundId(roundId);
        model.addAttribute("round",round);
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        List<Team> teamList= teamService.getTeamBySeminarControlId(seminarControl.getId());
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,courseId);
        boolean flag=teamList.contains(team);
        if(flag)
            return "student/selected_seminar_homepage" ;
        else if(seminarControl.getSeminarStatus().equals("UNSTARTED"))
            return "student/seminar_info_ready";
        else if(seminarControl.getSeminarStatus().equals("INPROCESS"))
            return "student/seminar_info_begin";
        else if(seminarControl.getSeminarStatus().equals("FINISHED"))
            return "student/seminar_info_complete";
        else
            return "error";
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
